package com.sensiblemetrics.api.alpenidos.pattern.commander.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

/**
 * Retry pattern
 *
 * @param <T> is the type of object passed into HandleErrorIssue as a parameter.
 */

public class Retry<T> {

    /**
     * Operation Interface will define method to be implemented.
     */
    public interface Operation {
        void operation(final List<Exception> list) throws Exception;
    }

    /**
     * HandleErrorIssue defines how to handle errors.
     *
     * @param <T> is the type of object to be passed into the method as parameter.
     */
    public interface HandleErrorIssue<T> {
        void handleIssue(final T obj, final Exception e);
    }

    private final Operation op;
    private final HandleErrorIssue<T> handleError;
    private final int maxAttempts;
    private final long maxDelay;
    private final AtomicInteger attempts;
    private final Predicate<Exception> test;
    private final ArrayList<Exception> errors;

    Retry(Operation op, HandleErrorIssue handleError, int maxAttempts, long maxDelay, Predicate<Exception>... ignoreTests) {
        this.op = op;
        this.handleError = handleError;
        this.maxAttempts = maxAttempts;
        this.maxDelay = maxDelay;
        this.attempts = new AtomicInteger();
        this.test = Arrays.stream(ignoreTests).reduce(Predicate::or).orElse(e -> false);
        this.errors = new ArrayList<>();
    }

    /**
     * Performing the operation with retries.
     *
     * @param list is the exception list
     * @param obj  is the parameter to be passed into handleIsuue method
     */
    public void perform(final List<Exception> list, final T obj) throws Exception {
        do {
            try {
                op.operation(list);
                return;
            } catch (Exception e) {
                this.errors.add(e);
                if (this.attempts.incrementAndGet() >= this.maxAttempts || !this.test.test(e)) {
                    this.handleError.handleIssue(obj, e);
                    return;
                }
                try {
                    final Random rand = new Random();
                    long testDelay = (long) Math.pow(2, this.attempts.intValue()) * 1000 + rand.nextInt(1000);
                    long delay = testDelay < this.maxDelay ? testDelay : maxDelay;
                    Thread.sleep(delay);
                } catch (InterruptedException f) {
                }
            }
        }
        while (true);
    }

}
