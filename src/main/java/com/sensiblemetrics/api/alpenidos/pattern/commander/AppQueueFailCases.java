package com.sensiblemetrics.api.alpenidos.pattern.commander;

import com.sensiblemetrics.api.alpenidos.pattern.commander.employee_service.EmployeeDatabase;
import com.sensiblemetrics.api.alpenidos.pattern.commander.employee_service.EmployeeHandle;
import com.sensiblemetrics.api.alpenidos.pattern.commander.exception.DatabaseUnavailableException;
import com.sensiblemetrics.api.alpenidos.pattern.commander.exception.ItemUnavailableException;
import com.sensiblemetrics.api.alpenidos.pattern.commander.impl.Commander;
import com.sensiblemetrics.api.alpenidos.pattern.commander.messaging_service.MessagingDatabase;
import com.sensiblemetrics.api.alpenidos.pattern.commander.messaging_service.MessagingService;
import com.sensiblemetrics.api.alpenidos.pattern.commander.model.Order;
import com.sensiblemetrics.api.alpenidos.pattern.commander.model.User;
import com.sensiblemetrics.api.alpenidos.pattern.commander.payment_service.PaymentDatabase;
import com.sensiblemetrics.api.alpenidos.pattern.commander.payment_service.PaymentService;
import com.sensiblemetrics.api.alpenidos.pattern.commander.queue.QueueDatabase;
import com.sensiblemetrics.api.alpenidos.pattern.commander.shipping_service.ShippingDatabase;
import com.sensiblemetrics.api.alpenidos.pattern.commander.shipping_service.ShippingService;

/**
 * AppQueueFailCases class looks at possible cases when Queue Database is
 * available/unavailable.
 */
public class AppQueueFailCases {
    private final int numOfRetries = 3;
    private final long retryDuration = 30000;
    private final long queueTime = 240000; //4 mins
    private final long queueTaskTime = 60000; //1 min
    private final long paymentTime = 120000; //2 mins
    private final long messageTime = 150000; //2.5 mins
    private final long employeeTime = 240000; //4 mins

    void queuePaymentTaskDatabaseUnavailableCase() throws Exception {
        final PaymentService ps = new PaymentService(
            new PaymentDatabase(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException()
        );
        final ShippingService ss = new ShippingService(new ShippingDatabase());
        final MessagingService ms = new MessagingService(new MessagingDatabase());
        final EmployeeHandle eh = new EmployeeHandle(new EmployeeDatabase());
        final QueueDatabase qdb = new QueueDatabase(
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException()
        );
        final Commander c = new Commander(eh, ps, ss, ms, qdb, numOfRetries, retryDuration, queueTime, queueTaskTime, paymentTime, messageTime, employeeTime);
        final User user = new User("Jim", "ABCD");
        final Order order = new Order(user, "book", 10f);
        c.placeOrder(order);
    }

    void queueMessageTaskDatabaseUnavailableCase() throws Exception {
        final PaymentService ps = new PaymentService(new PaymentDatabase());
        final ShippingService ss = new ShippingService(new ShippingDatabase());
        final MessagingService ms = new MessagingService(
            new MessagingDatabase(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException()
        );
        final EmployeeHandle eh = new EmployeeHandle(new EmployeeDatabase());
        final QueueDatabase qdb = new QueueDatabase(
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException()
        );
        final Commander c = new Commander(eh, ps, ss, ms, qdb, numOfRetries, retryDuration, queueTime, queueTaskTime, paymentTime, messageTime, employeeTime);
        final User user = new User("Jim", "ABCD");
        final Order order = new Order(user, "book", 10f);
        c.placeOrder(order);
    }

    void queueEmployeeDbTaskDatabaseUnavailableCase() throws Exception {
        final PaymentService ps = new PaymentService(new PaymentDatabase());
        final ShippingService ss = new ShippingService(
            new ShippingDatabase(),
            new ItemUnavailableException()
        );
        final MessagingService ms = new MessagingService(new MessagingDatabase());
        final EmployeeHandle eh = new EmployeeHandle(
            new EmployeeDatabase(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException()
        );
        final QueueDatabase qdb = new QueueDatabase(
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException()
        );
        final Commander c = new Commander(eh, ps, ss, ms, qdb, numOfRetries, retryDuration, queueTime, queueTaskTime, paymentTime, messageTime, employeeTime);
        final User user = new User("Jim", "ABCD");
        final Order order = new Order(user, "book", 10f);
        c.placeOrder(order);
    }

    void queueSuccessCase() throws Exception {
        final PaymentService ps = new PaymentService(
            new PaymentDatabase(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException()
        );
        final ShippingService ss = new ShippingService(new ShippingDatabase());
        final MessagingService ms = new MessagingService(
            new MessagingDatabase(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException()
        );
        final EmployeeHandle eh = new EmployeeHandle(new EmployeeDatabase());
        final QueueDatabase qdb = new QueueDatabase(
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException()
        );
        final Commander c = new Commander(eh, ps, ss, ms, qdb, numOfRetries, retryDuration, queueTime, queueTaskTime, paymentTime, messageTime, employeeTime);
        final User user = new User("Jim", "ABCD");
        final Order order = new Order(user, "book", 10f);
        c.placeOrder(order);
    }

    /**
     * Program entry point.
     *
     * @param args command line args
     */
    public static void main(final String[] args) throws Exception {
        AppQueueFailCases aqfc = new AppQueueFailCases();
        //aqfc.queuePaymentTaskDatabaseUnavailableCase();
        //aqfc.queueMessageTaskDatabaseUnavailableCase();
        //aqfc.queueEmployeeDbTaskDatabaseUnavailableCase();
        aqfc.queueSuccessCase();
    }
}
