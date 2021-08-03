package com.sensiblemetrics.api.alpenidos.pattern.promise.impl;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * A really simplified implementation of future that allows completing it successfully with a value
 * or exceptionally with an exception.
 */
@Slf4j
public class PromiseSupport<T> implements Future<T> {
    private static final int RUNNING = 1;
    private static final int FAILED = 2;
    private static final int COMPLETED = 3;

    private final Object lock;

    private volatile int state = RUNNING;
    private T value;
    private Exception exception;

    PromiseSupport() {
        this.lock = new Object();
    }

    void fulfill(final T value) {
        this.value = value;
        this.state = COMPLETED;
        synchronized (this.lock) {
            this.lock.notifyAll();
        }
    }

    void fulfillExceptionally(final Exception exception) {
        this.exception = exception;
        this.state = FAILED;
        synchronized (this.lock) {
            this.lock.notifyAll();
        }
    }

    @Override
    public boolean cancel(final boolean mayInterruptIfRunning) {
        return false;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public boolean isDone() {
        return this.state > RUNNING;
    }

    @Override
    public T get() throws InterruptedException, ExecutionException {
        synchronized (this.lock) {
            while (state == RUNNING) {
                this.lock.wait();
            }
        }
        if (this.state == COMPLETED) {
            return value;
        }
        throw new ExecutionException(this.exception);
    }

    @Override
    public T get(final long timeout, final TimeUnit unit) throws ExecutionException {
        synchronized (this.lock) {
            while (state == RUNNING) {
                try {
                    this.lock.wait(unit.toMillis(timeout));
                } catch (InterruptedException e) {
                    log.warn("Interrupted!", e);
                    Thread.currentThread().interrupt();
                }
            }
        }
        if (this.state == COMPLETED) {
            return value;
        }
        throw new ExecutionException(this.exception);
    }
}
