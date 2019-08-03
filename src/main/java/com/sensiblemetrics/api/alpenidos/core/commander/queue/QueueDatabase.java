package com.sensiblemetrics.api.alpenidos.core.commander.queue;

import com.sensiblemetrics.api.alpenidos.core.commander.impl.Database;
import com.sensiblemetrics.api.alpenidos.core.commander.exception.DatabaseUnavailableException;
import com.sensiblemetrics.api.alpenidos.core.commander.exception.IsEmptyException;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * QueueDatabase id where the instructions to be implemented are queued.
 */

public class QueueDatabase extends Database<QueueTask> {
    private final Queue<QueueTask> data;
    public final ArrayList<Exception> exceptionsList;

    public QueueDatabase(final Exception... exc) {
        this.data = new Queue<>();
        this.exceptionsList = new ArrayList<>(Arrays.asList(exc));
    }

    @Override
    public QueueTask add(final QueueTask t) throws DatabaseUnavailableException {
        this.data.enqueue(t);
        return t;
    }

    /**
     * peek method returns object at front without removing it from queue
     *
     * @return object at front of queue
     * @throws IsEmptyException             if queue is empty
     * @throws DatabaseUnavailableException if queue db is unavailable
     */

    public QueueTask peek() throws IsEmptyException, DatabaseUnavailableException {
        final QueueTask qt = this.data.peek();
        return qt;
    }

    /**
     * dequeue method removes the object at front and returns it
     *
     * @return object at front of queue
     * @throws IsEmptyException             if queue is empty
     * @throws DatabaseUnavailableException if queue db is unavailable
     */

    public QueueTask dequeue() throws IsEmptyException, DatabaseUnavailableException {
        final QueueTask qt = this.data.dequeue();
        return qt;
    }

    @Override
    public QueueTask get(final String tId) throws DatabaseUnavailableException {
        return null;
    }
}
