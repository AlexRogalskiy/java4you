package com.sensiblemetrics.api.alpenidos.core.guarded_suspension.impl;

import java.util.LinkedList;
import java.util.Queue;
import lombok.extern.slf4j.Slf4j;

/**
 * Guarded Queue is an implementation for Guarded Suspension Pattern Guarded suspension pattern is used to handle a situation when you want to execute a method
 * on an object which is not in a proper state.
 *
 * @see <a href="http://java-design-patterns.com/patterns/guarded-suspension/">http://java-design-patterns.com/patterns/guarded-suspension/</a>
 */
@Slf4j
public class GuardedQueue {

    private final Queue<Integer> sourceList;

    public GuardedQueue() {
        this.sourceList = new LinkedList<>();
    }

    /**
     * @return last element of a queue if queue is not empty
     */
    public synchronized Integer get() {
        while (this.sourceList.isEmpty()) {
            try {
                log.info("waiting");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        log.info("getting");
        return this.sourceList.peek();
    }

    /**
     * @param e number which we want to put to our queue
     */
    public synchronized void put(final Integer e) {
        log.info("putting");
        this.sourceList.add(e);
        log.info("notifying");
        this.notify();
    }
}
