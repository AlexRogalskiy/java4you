package com.sensiblemetrics.api.alpenidos.pattern.commander.queue;

import com.sensiblemetrics.api.alpenidos.pattern.commander.model.Order;

/**
 * QueueTask object is the object enqueued in queue.
 */
public class QueueTask {

    /**
     * TaskType is the type of task to be done.
     */
    public enum TaskType {
        Messaging,
        Payment,
        EmployeeDb
    }

    public Order order;
    public TaskType taskType;
    public int messageType; //0-fail, 1-error, 2-success
    /*we could have varargs Object instead to pass in any parameter instead of just message type
    but keeping it simple here*/
    public long firstAttemptTime; //when first time attempt made to do task

    /**
     * QueueTask constructor
     *
     * @param o           is the order for which the queuetask is being created
     * @param t           is the type of task to be done
     * @param messageType if it is a message, which type of message - this could have instead been object varargs,
     *                    and contained all additional details related to tasktype.
     */
    public QueueTask(final Order o, final TaskType t, final int messageType) {
        this.order = o;
        this.taskType = t;
        this.messageType = messageType;
        this.firstAttemptTime = -1;
    }

    /**
     * getType method
     *
     * @return String representing type of task
     */
    public String getType() {
        if (!this.taskType.equals(TaskType.Messaging)) {
            return this.taskType.toString();
        } else {
            if (this.messageType == 0) {
                return "Payment Failure Message";
            } else if (this.messageType == 1) {
                return "Payment Error Message";
            }
            return "Payment Success Message";
        }
    }
}
