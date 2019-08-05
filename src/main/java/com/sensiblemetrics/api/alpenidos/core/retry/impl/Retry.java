package com.sensiblemetrics.api.alpenidos.core.retry.impl;

import com.sensiblemetrics.api.alpenidos.core.retry.exception.BusinessException;
import com.sensiblemetrics.api.alpenidos.core.retry.iface.BusinessOperation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

/**
 * Decorates {@link BusinessOperation business operation} with "retry" capabilities.
 *
 * @param <T> the remote op's return type
 * @author George Aristy (george.aristy@gmail.com)
 */
public final class Retry<T> implements BusinessOperation<T> {
    private final BusinessOperation<T> op;
    private final int maxAttempts;
    private final long delay;
    private final AtomicInteger attempts;
    private final Predicate<Exception> test;
    private final List<Exception> errors;

    /**
     * Ctor.
     *
     * @param op          the {@link BusinessOperation} to retry
     * @param maxAttempts number of times to retry
     * @param delay       delay (in milliseconds) between attempts
     * @param ignoreTests tests to check whether the remote exception can be ignored. No exceptions
     *                    will be ignored if no tests are given
     */
    @SafeVarargs
    public Retry(final BusinessOperation<T> op, final int maxAttempts, final long delay, final Predicate<Exception>... ignoreTests) {
        this.op = op;
        this.maxAttempts = maxAttempts;
        this.delay = delay;
        this.attempts = new AtomicInteger();
        this.test = Arrays.stream(ignoreTests).reduce(Predicate::or).orElse(e -> false);
        this.errors = new ArrayList<>();
    }

    /**
     * The errors encountered while retrying, in the encounter order.
     *
     * @return the errors encountered while retrying
     */
    public List<Exception> errors() {
        return Collections.unmodifiableList(this.errors);
    }

    /**
     * The number of retries performed.
     *
     * @return the number of retries performed
     */
    public int attempts() {
        return this.attempts.intValue();
    }

    @Override
    public T perform() throws BusinessException {
        do {
            try {
                return this.op.perform();
            } catch (BusinessException e) {
                this.errors.add(e);
                if (this.attempts.incrementAndGet() >= this.maxAttempts || !this.test.test(e)) {
                    throw e;
                }

                try {
                    Thread.sleep(this.delay);
                } catch (InterruptedException f) {
                }
            }
        }
        while (true);
    }
}
