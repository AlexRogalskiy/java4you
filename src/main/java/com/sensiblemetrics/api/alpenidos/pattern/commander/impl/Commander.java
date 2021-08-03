package com.sensiblemetrics.api.alpenidos.pattern.commander.impl;

import com.sensiblemetrics.api.alpenidos.pattern.commander.*;
import com.sensiblemetrics.api.alpenidos.pattern.commander.employee_service.EmployeeHandle;
import com.sensiblemetrics.api.alpenidos.pattern.commander.exception.DatabaseUnavailableException;
import com.sensiblemetrics.api.alpenidos.pattern.commander.exception.ItemUnavailableException;
import com.sensiblemetrics.api.alpenidos.pattern.commander.exception.PaymentDetailsErrorException;
import com.sensiblemetrics.api.alpenidos.pattern.commander.exception.ShippingNotPossibleException;
import com.sensiblemetrics.api.alpenidos.pattern.commander.messaging_service.MessagingService;
import com.sensiblemetrics.api.alpenidos.pattern.commander.model.Order;
import com.sensiblemetrics.api.alpenidos.pattern.commander.payment_service.PaymentService;
import com.sensiblemetrics.api.alpenidos.pattern.commander.queue.QueueDatabase;
import com.sensiblemetrics.api.alpenidos.pattern.commander.queue.QueueTask;
import com.sensiblemetrics.api.alpenidos.pattern.commander.shipping_service.ShippingService;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

/**
 * <p>Commander pattern is used to handle all issues that can come up while making a
 * distributed transaction. The idea is to have a commander, which coordinates the
 * execution of all instructions and ensures proper completion using retries and
 * taking care of idempotence. By queueing instructions while they haven't been done,
 * we can ensure a state of 'eventual consistency'.</p>
 * <p>In our example, we have an e-commerce application. When the user places an order,
 * the shipping service is intimated first. If the service does not respond for some
 * reason, the order is not placed. If response is received, the commander then calls
 * for the payment service to be intimated. If this fails, the shipping still takes
 * place (order converted to COD) and the item is queued. If the queue is also found
 * to be unavailable, the payment is noted to be not done and this is added to an
 * employee database. Three types of messages are sent to the user - one, if payment
 * succeeds; two, if payment fails definitively; and three, if payment fails in the
 * first attempt. If the message is not sent, this is also queued and is added to employee
 * db. We also have a time limit for each instruction to be completed, after which, the
 * instruction is not executed, thereby ensuring that resources are not held for too long.
 * In the rare occasion in which everything fails, an individual would have to step in to
 * figure out how to solve the issue.</p>
 * <p>We have abstract classes {@link Database} and {@link Service} which are extended
 * by all the databases and services. Each service has a database to be updated, and
 * receives request from an outside user (the {@link Commander} class here). There are
 * 5 microservices - {@link ShippingService}, {@link PaymentService}, {@link MessagingService},
 * {@link EmployeeHandle} and a {@link QueueDatabase}. We use retries to execute any
 * instruction using {@link Retry} class, and idempotence is ensured by going through some
 * checks before making requests to services and making change in {@link Order} class fields
 * if request succeeds or definitively fails. There are 5 classes -
 * {@link AppShippingFailCases}, {@link AppPaymentFailCases}, {@link AppMessagingFailCases},
 * {@link AppQueueFailCases} and {@link AppEmployeeDbFailCases}, which look at the different
 * scenarios that may be encountered during the placing of an order.</p>
 */
@Slf4j
public class Commander {
    private final QueueDatabase queue;
    private final EmployeeHandle employeeDb;
    private final PaymentService paymentService;
    private final ShippingService shippingService;
    private final MessagingService messagingService;
    private int queueItems = 0; //keeping track here only so don't need access to queue db to get this
    private final int numOfRetries;
    private final long retryDuration;
    private final long queueTime;
    private final long queueTaskTime;
    private final long paymentTime;
    private final long messageTime;
    private final long employeeTime;
    private boolean finalSiteMsgShown;

    public Commander(EmployeeHandle empDb, PaymentService pService, ShippingService sService,
                     MessagingService mService, QueueDatabase qdb, int numOfRetries, long retryDuration,
                     long queueTime, long queueTaskTime, long paymentTime, long messageTime, long employeeTime) {
        this.paymentService = pService;
        this.shippingService = sService;
        this.messagingService = mService;
        this.employeeDb = empDb;
        this.queue = qdb;
        this.numOfRetries = numOfRetries;
        this.retryDuration = retryDuration;
        this.queueTime = queueTime;
        this.queueTaskTime = queueTaskTime;
        this.paymentTime = paymentTime;
        this.messageTime = messageTime;
        this.employeeTime = employeeTime;
        this.finalSiteMsgShown = false;
    }

    public void placeOrder(Order order) throws Exception {
        sendShippingRequest(order);
    }

    private void sendShippingRequest(Order order) throws Exception {
        ArrayList<Exception> list = shippingService.exceptionsList;
        Retry.Operation op = (l) -> {
            if (!l.isEmpty()) {
                if (DatabaseUnavailableException.class.isAssignableFrom(l.get(0).getClass())) {
                    log.debug("Order " + order.id + ": Error in connecting to shipping service, trying again..");
                } else {
                    log.debug("Order " + order.id + ": Error in creating shipping request..");
                }
                throw l.remove(0);
            }
            String transactionId = shippingService.receiveRequest(order.getItem(), order.getUser().getAddress());
            //could save this transaction id in a db too
            log.info("Order " + order.id + ": Shipping placed successfully, transaction id: " + transactionId);
            System.out.println("Order has been placed and will be shipped to you. Please wait while we make your"
                + " payment... ");
            sendPaymentRequest(order);
            return;
        };
        Retry.HandleErrorIssue<Order> handleError = (o, err) -> {
            if (ShippingNotPossibleException.class.isAssignableFrom(err.getClass())) {
                System.out.println("Shipping is currently not possible to your address. We are working on the problem "
                    + "and will get back to you asap.");
                finalSiteMsgShown = true;
                log.info("Order " + order.id + ": Shipping not possible to address, trying to add problem to employee db..");
                employeeHandleIssue(o);
            } else if (ItemUnavailableException.class.isAssignableFrom(err.getClass())) {
                System.out.println("This item is currently unavailable. We will inform you as soon as the item becomes "
                    + "available again.");
                finalSiteMsgShown = true;
                log.info("Order " + order.id + ": Item " + order.getItem() + " unavailable, trying to add problem to employee "
                    + "handle..");
                employeeHandleIssue(o);
            } else {
                System.out.println("Sorry, there was a problem in creating your order. Please try later.");
                log.error("Order " + order.id + ": Shipping service unavailable, order not placed..");
                finalSiteMsgShown = true;
            }
            return;
        };
        Retry<Order> r = new Retry<>(op, handleError, numOfRetries, retryDuration,
            e -> DatabaseUnavailableException.class.isAssignableFrom(e.getClass()));
        r.perform(list, order);
    }

    private void sendPaymentRequest(final Order order) {
        if (System.currentTimeMillis() - order.getCreatedTime() >= this.paymentTime) {
            if (order.getPaid().equals(Order.PaymentStatus.Trying)) {
                order.setPaid(Order.PaymentStatus.NotDone);
                sendPaymentFailureMessage(order);
                log.error("Order " + order.id + ": Payment time for order over, failed and returning..");
            } //if succeeded or failed, would have been dequeued, no attempt to make payment
            return;
        }
        ArrayList<Exception> list = paymentService.exceptionsList;
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                Retry.Operation op = (l) -> {
                    if (!l.isEmpty()) {
                        if (DatabaseUnavailableException.class.isAssignableFrom(l.get(0).getClass())) {
                            log.debug("Order " + order.id + ": Error in connecting to payment service, trying again..");
                        } else {
                            log.debug("Order " + order.id + ": Error in creating payment request..");
                        }
                        throw l.remove(0);
                    }
                    if (order.getPaid().equals(Order.PaymentStatus.Trying)) {
                        String transactionId = paymentService.receiveRequest(order.getPrice());
                        order.setPaid(Order.PaymentStatus.Done);
                        log.info("Order " + order.id + ": Payment successful, transaction Id: " + transactionId);
                        if (!finalSiteMsgShown) {
                            System.out.println("Payment made successfully, thank you for shopping with us!!");
                            finalSiteMsgShown = true;
                        }
                        sendSuccessMessage(order);
                        return;
                    }
                };
                Retry.HandleErrorIssue<Order> handleError = (o, err) -> {
                    if (PaymentDetailsErrorException.class.isAssignableFrom(err.getClass())) {
                        if (!finalSiteMsgShown) {
                            System.out.println("There was an error in payment. Your account/card details may have been incorrect. "
                                + "Meanwhile, your order has been converted to COD and will be shipped.");
                            finalSiteMsgShown = true;
                        }
                        log.error("Order " + order.id + ": Payment details incorrect, failed..");
                        o.setPaid(Order.PaymentStatus.NotDone);
                        sendPaymentFailureMessage(o);
                    } else {
                        try {
                            if (o.getMessageSent().equals(Order.MessageSent.NoneSent)) {
                                if (!finalSiteMsgShown) {
                                    System.out.println("There was an error in payment. We are on it, and will get back to you "
                                        + "asap. Don't worry, your order has been placed and will be shipped.");
                                    finalSiteMsgShown = true;
                                }
                                log.warn("Order " + order.id + ": Payment error, going to queue..");
                                sendPaymentPossibleErrorMsg(o);
                            }
                            if (o.getPaid().equals(Order.PaymentStatus.Trying) && System.currentTimeMillis() - o.getCreatedTime() < paymentTime) {
                                final QueueTask qt = new QueueTask(o, QueueTask.TaskType.Payment, -1);
                                updateQueue(qt);
                            }
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        }
                    }
                    return;
                };
                Retry<Order> r = new Retry<Order>(op, handleError, numOfRetries, retryDuration,
                    e -> DatabaseUnavailableException.class.isAssignableFrom(e.getClass()));
                try {
                    r.perform(list, order);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        t.start();
    }

    private void updateQueue(QueueTask qt) throws InterruptedException {
        if (System.currentTimeMillis() - qt.order.getCreatedTime() >= this.queueTime) {
            //since payment time is lesser than queuetime it would have already failed..additional check not needed
            log.trace("Order " + qt.order.id + ": Queue time for order over, failed..");
            return;
        } else if ((qt.taskType.equals(QueueTask.TaskType.Payment) && !qt.order.getPaid().equals(Order.PaymentStatus.Trying))
            || (qt.taskType.equals(QueueTask.TaskType.Messaging) && ((qt.messageType == 1
            && !qt.order.getMessageSent().equals(Order.MessageSent.NoneSent))
            || qt.order.getMessageSent().equals(Order.MessageSent.PaymentFail)
            || qt.order.getMessageSent().equals(Order.MessageSent.PaymentSuccessful)))
            || (qt.taskType.equals(QueueTask.TaskType.EmployeeDb) && qt.order.isAddedToEmployeeHandle())) {
            log.trace("Order " + qt.order.id + ": Not queueing task since task already done..");
            return;
        }
        ArrayList<Exception> list = queue.exceptionsList;
        Thread t = new Thread(() -> {
            Retry.Operation op = (list1) -> {
                if (!list1.isEmpty()) {
                    log.warn("Order " + qt.order.id + ": Error in connecting to queue db, trying again..");
                    throw list1.remove(0);
                }
                queue.add(qt);
                queueItems++;
                log.info("Order " + qt.order.id + ": " + qt.getType() + " task enqueued..");
                tryDoingTasksInQueue();
                return;
            };
            Retry.HandleErrorIssue<QueueTask> handleError = (qt1, err) -> {
                if (qt1.taskType.equals(QueueTask.TaskType.Payment)) {
                    qt1.order.setPaid(Order.PaymentStatus.NotDone);
                    sendPaymentFailureMessage(qt1.order);
                    log.error("Order " + qt1.order.id + ": Unable to enqueue payment task, payment failed..");
                }
                log.error("Order " + qt1.order.id + ": Unable to enqueue task of type " + qt1.getType() + ", trying to add to employee handle..");
                employeeHandleIssue(qt1.order);
                return;
            };
            Retry<QueueTask> r = new Retry<>(op, handleError, numOfRetries, retryDuration,
                e -> DatabaseUnavailableException.class.isAssignableFrom(e.getClass()));
            try {
                r.perform(list, qt);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        t.start();
    }

    private void tryDoingTasksInQueue() { //commander controls operations done to queue
        ArrayList<Exception> list = queue.exceptionsList;
        Thread t2 = new Thread(() -> {
            Retry.Operation op = (list1) -> {
                if (!list1.isEmpty()) {
                    log.warn("Error in accessing queue db to do tasks, trying again..");
                    throw list1.remove(0);
                }
                doTasksInQueue();
                return;
            };
            Retry.HandleErrorIssue<QueueTask> handleError = (o, err) -> {
                return;
            };
            Retry<QueueTask> r = new Retry<>(op, handleError, numOfRetries, retryDuration,
                e -> DatabaseUnavailableException.class.isAssignableFrom(e.getClass()));
            try {
                r.perform(list, null);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        t2.start();
    }

    private void tryDequeue() {
        ArrayList<Exception> list = queue.exceptionsList;
        Thread t3 = new Thread(() -> {
            Retry.Operation op = (list1) -> {
                if (!list1.isEmpty()) {
                    log.warn("Error in accessing queue db to dequeue task, trying again..");
                    throw list1.remove(0);
                }
                queue.dequeue();
                queueItems--;
                return;
            };
            Retry.HandleErrorIssue<QueueTask> handleError = (o, err) -> {
                return;
            };
            Retry<QueueTask> r = new Retry<>(op, handleError, numOfRetries, retryDuration,
                e -> DatabaseUnavailableException.class.isAssignableFrom(e.getClass()));
            try {
                r.perform(list, null);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        t3.start();
    }

    private void sendSuccessMessage(Order order) {
        if (System.currentTimeMillis() - order.getCreatedTime() >= this.messageTime) {
            log.trace("Order " + order.id + ": Message time for order over, returning..");
            return;
        }
        ArrayList<Exception> list = messagingService.exceptionsList;
        Thread t = new Thread(() -> {
            Retry.Operation op = (l) -> {
                if (!l.isEmpty()) {
                    if (DatabaseUnavailableException.class.isAssignableFrom(l.get(0).getClass())) {
                        log.debug("Order " + order.id + ": Error in connecting to messaging service "
                            + "(Payment Success msg), trying again..");
                    } else {
                        log.debug("Order " + order.id + ": Error in creating Payment Success messaging request..");
                    }
                    throw l.remove(0);
                }
                if (!order.getMessageSent().equals(Order.MessageSent.PaymentFail)
                    && !order.getMessageSent().equals(Order.MessageSent.PaymentSuccessful)) {
                    String requestId = messagingService.receiveRequest(2);
                    order.setMessageSent(Order.MessageSent.PaymentSuccessful);
                    log.info("Order " + order.id + ": Payment Success message sent, request Id: " + requestId);
                }
                return;
            };
            Retry.HandleErrorIssue<Order> handleError = (o, err) -> {
                try {
                    if ((o.getMessageSent().equals(Order.MessageSent.NoneSent) || o.getMessageSent().equals(Order.MessageSent.PaymentTrying))
                        && System.currentTimeMillis() - o.getCreatedTime() < messageTime) {
                        QueueTask qt = new QueueTask(order, QueueTask.TaskType.Messaging, 2);
                        updateQueue(qt);
                        log.info("Order " + order.id + ": Error in sending Payment Success message, trying to "
                            + "queue task and add to employee handle..");
                        employeeHandleIssue(order);
                    }
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                return;
            };
            Retry<Order> r = new Retry<>(op, handleError, numOfRetries, retryDuration,
                e -> DatabaseUnavailableException.class.isAssignableFrom(e.getClass()));
            try {
                r.perform(list, order);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        t.start();
    }

    private void sendPaymentFailureMessage(final Order order) {
        if (System.currentTimeMillis() - order.getCreatedTime() >= this.messageTime) {
            log.trace("Order " + order.id + ": Message time for order over, returning..");
            return;
        }
        ArrayList<Exception> list = messagingService.exceptionsList;
        final Thread t = new Thread(() -> {
            Retry.Operation op = (l) -> {
                if (!l.isEmpty()) {
                    if (DatabaseUnavailableException.class.isAssignableFrom(l.get(0).getClass())) {
                        log.debug("Order " + order.id + ": Error in connecting to messaging service "
                            + "(Payment Failure msg), trying again..");
                    } else {
                        log.debug("Order " + order.id + ": Error in creating Payment Failure message request..");
                    }
                    throw l.remove(0);
                }
                if (!order.getMessageSent().equals(Order.MessageSent.PaymentFail)
                    && !order.getMessageSent().equals(Order.MessageSent.PaymentSuccessful)) {
                    String requestId = messagingService.receiveRequest(0);
                    order.setMessageSent(Order.MessageSent.PaymentFail);
                    log.info("Order " + order.id + ": Payment Failure message sent successfully, request Id: " + requestId);
                }
                return;
            };
            Retry.HandleErrorIssue<Order> handleError = (o, err) -> {
                if ((o.getMessageSent().equals(Order.MessageSent.NoneSent) || o.getMessageSent().equals(Order.MessageSent.PaymentTrying))
                    && System.currentTimeMillis() - o.getCreatedTime() < messageTime) {
                    try {
                        QueueTask qt = new QueueTask(order, QueueTask.TaskType.Messaging, 0);
                        updateQueue(qt);
                        log.warn("Order " + order.id + ": Error in sending Payment Failure message, " + "trying to queue task and add to employee handle..");
                        employeeHandleIssue(o);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    return;
                }
            };
            Retry<Order> r = new Retry<Order>(op, handleError, numOfRetries, retryDuration,
                e -> DatabaseUnavailableException.class.isAssignableFrom(e.getClass()));
            try {
                r.perform(list, order);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        t.start();
    }

    private void sendPaymentPossibleErrorMsg(Order order) {
        if (System.currentTimeMillis() - order.getCreatedTime() >= this.messageTime) {
            log.trace("Message time for order over, returning..");
            return;
        }
        ArrayList<Exception> list = messagingService.exceptionsList;
        Thread t = new Thread(() -> {
            Retry.Operation op = (l) -> {
                if (!l.isEmpty()) {
                    if (DatabaseUnavailableException.class.isAssignableFrom(l.get(0).getClass())) {
                        log.debug("Order " + order.id + ": Error in connecting to messaging service "
                            + "(Payment Error msg), trying again..");
                    } else {
                        log.debug("Order " + order.id + ": Error in creating Payment Error messaging request..");
                    }
                    throw l.remove(0);
                }
                if (order.getPaid().equals(Order.PaymentStatus.Trying) && order.getMessageSent().equals(Order.MessageSent.NoneSent)) {
                    String requestId = messagingService.receiveRequest(1);
                    order.setMessageSent(Order.MessageSent.PaymentTrying);
                    log.info("Order " + order.id + ": Payment Error message sent successfully, request Id: " + requestId);
                }
                return;
            };
            Retry.HandleErrorIssue<Order> handleError = (o, err) -> {
                try {
                    if (o.getMessageSent().equals(Order.MessageSent.NoneSent)
                        && order.getPaid().equals(Order.PaymentStatus.Trying)
                        && System.currentTimeMillis() - o.getCreatedTime() < messageTime) {
                        final QueueTask qt = new QueueTask(order, QueueTask.TaskType.Messaging, 1);
                        this.updateQueue(qt);
                        log.warn("Order " + order.id + ": Error in sending Payment Error message, " + "trying to queue task and add to employee handle..");
                        employeeHandleIssue(o);
                    }
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                return;
            };
            Retry<Order> r = new Retry<>(op, handleError, numOfRetries, retryDuration,
                e -> DatabaseUnavailableException.class.isAssignableFrom(e.getClass()));
            try {
                r.perform(list, order);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        t.start();
    }

    private void employeeHandleIssue(final Order order) {
        if (System.currentTimeMillis() - order.getCreatedTime() >= this.employeeTime) {
            log.trace("Order " + order.id + ": Employee handle time for order over, returning..");
            return;
        }
        ArrayList<Exception> list = employeeDb.exceptionsList;
        Thread t = new Thread(() -> {
            Retry.Operation op = (l) -> {
                if (!l.isEmpty()) {
                    log.warn("Order " + order.id + ": Error in connecting to employee handle, trying again..");
                    throw l.remove(0);
                }
                if (!order.isAddedToEmployeeHandle()) {
                    employeeDb.receiveRequest(order);
                    order.setAddedToEmployeeHandle(true);
                    log.info("Order " + order.id + ": Added order to employee database");
                }
                return;
            };
            Retry.HandleErrorIssue<Order> handleError = (o, err) -> {
                try {
                    if (!o.isAddedToEmployeeHandle() && System.currentTimeMillis() - order.getCreatedTime() < employeeTime) {
                        QueueTask qt = new QueueTask(order, QueueTask.TaskType.EmployeeDb, -1);
                        updateQueue(qt);
                        log.warn("Order " + order.id + ": Error in adding to employee db, trying to queue task..");
                        return;
                    }
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                return;
            };
            Retry<Order> r = new Retry<Order>(op, handleError, numOfRetries, retryDuration,
                e -> DatabaseUnavailableException.class.isAssignableFrom(e.getClass()));
            try {
                r.perform(list, order);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        t.start();
    }

    private void doTasksInQueue() throws Exception {
        if (queueItems != 0) {
            QueueTask qt = queue.peek(); //this should probably be cloned here
            //this is why we have retry for doTasksInQueue
            log.trace("Order " + qt.order.id + ": Started doing task of type " + qt.getType());
            if (qt.firstAttemptTime == -1) {
                qt.firstAttemptTime = System.currentTimeMillis();
            }
            if (System.currentTimeMillis() - qt.firstAttemptTime >= queueTaskTime) {
                tryDequeue();
                log.trace("Order " + qt.order.id + ": This queue task of type " + qt.getType() + " does not need to be done anymore (timeout), dequeue..");
            } else {
                if (qt.taskType.equals(QueueTask.TaskType.Payment)) {
                    if (!qt.order.getPaid().equals(Order.PaymentStatus.Trying)) {
                        tryDequeue();
                        log.trace("Order " + qt.order.id + ": This payment task already done, dequeueing..");
                    } else {
                        sendPaymentRequest(qt.order);
                        log.debug("Order " + qt.order.id + ": Trying to connect to payment service..");
                    }
                } else if (qt.taskType.equals(QueueTask.TaskType.Messaging)) {
                    if (qt.order.getMessageSent().equals(Order.MessageSent.PaymentFail)
                        || qt.order.getMessageSent().equals(Order.MessageSent.PaymentSuccessful)) {
                        tryDequeue();
                        log.trace("Order " + qt.order.id + ": This messaging task already done, dequeue..");
                    } else if ((qt.messageType == 1 && (!qt.order.getMessageSent().equals(Order.MessageSent.NoneSent)
                        || !qt.order.getPaid().equals(Order.PaymentStatus.Trying)))) {
                        tryDequeue();
                        log.trace("Order " + qt.order.id + ": This messaging task does not need to be done, dequeue..");
                    } else if (qt.messageType == 0) {
                        sendPaymentFailureMessage(qt.order);
                        log.debug("Order " + qt.order.id + ": Trying to connect to messaging service..");
                    } else if (qt.messageType == 1) {
                        sendPaymentPossibleErrorMsg(qt.order);
                        log.debug("Order " + qt.order.id + ": Trying to connect to messaging service..");
                    } else if (qt.messageType == 2) {
                        sendSuccessMessage(qt.order);
                        log.debug("Order " + qt.order.id + ": Trying to connect to messaging service..");
                    }
                } else if (qt.taskType.equals(QueueTask.TaskType.EmployeeDb)) {
                    if (qt.order.isAddedToEmployeeHandle()) {
                        tryDequeue();
                        log.trace("Order " + qt.order.id + ": This employee handle task already done, dequeue..");
                    } else {
                        employeeHandleIssue(qt.order);
                        log.debug("Order " + qt.order.id + ": Trying to connect to employee handle..");
                    }
                }
            }
        }
        if (queueItems == 0) {
            log.trace("Queue is empty, returning..");
        } else {
            Thread.sleep(queueTaskTime / 3);
            tryDoingTasksInQueue();
        }
        return;
    }
}
