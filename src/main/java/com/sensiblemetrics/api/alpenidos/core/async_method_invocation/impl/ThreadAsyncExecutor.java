package com.sensiblemetrics.api.alpenidos.core.async_method_invocation.impl;

import com.sensiblemetrics.api.alpenidos.core.async_method_invocation.iface.AsyncCallback;
import com.sensiblemetrics.api.alpenidos.core.async_method_invocation.iface.AsyncExecutor;
import com.sensiblemetrics.api.alpenidos.core.async_method_invocation.iface.AsyncResult;

import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Implementation of async executor that creates a new thread for every task.
 */
public class ThreadAsyncExecutor implements AsyncExecutor {

    /**
     * Index for thread naming
     */
    private final AtomicInteger idx = new AtomicInteger(0);

    @Override
    public <T> AsyncResult<T> startProcess(final Callable<T> task) {
        return this.startProcess(task, null);
    }

    @Override
    public <T> AsyncResult<T> startProcess(final Callable<T> task, final AsyncCallback<T> callback) {
        final CompletableResult<T> result = new CompletableResult<>(callback);
        new Thread(() -> {
            try {
                result.setValue(task.call());
            } catch (Exception ex) {
                result.setException(ex);
            }
        }, "executor-" + idx.incrementAndGet()).start();
        return result;
    }

    @Override
    public <T> T endProcess(final AsyncResult<T> asyncResult) throws ExecutionException, InterruptedException {
        if (!asyncResult.isCompleted()) {
            asyncResult.await();
        }
        return asyncResult.getValue();
    }

    /**
     * Simple implementation of async result that allows completing it successfully with a value or exceptionally with an
     * exception. A really simplified version from its real life cousins FutureTask and CompletableFuture.
     *
     * @see java.util.concurrent.FutureTask
     * @see java.util.concurrent.CompletableFuture
     */
    private static class CompletableResult<T> implements AsyncResult<T> {

        private static final int RUNNING = 1;
        private static final int FAILED = 2;
        private static final int COMPLETED = 3;

        private final Object lock;
        private final Optional<AsyncCallback<T>> callback;

        private volatile int state = RUNNING;
        private T value;
        private Exception exception;

        public CompletableResult(final AsyncCallback<T> callback) {
            this.lock = new Object();
            this.callback = Optional.ofNullable(callback);
        }

        /**
         * Sets the value from successful execution and executes callback if available. Notifies any thread waiting for
         * completion.
         *
         * @param value value of the evaluated task
         */
        void setValue(final T value) {
            this.value = value;
            this.state = COMPLETED;
            this.callback.ifPresent(ac -> ac.onComplete(value, Optional.<Exception>empty()));
            synchronized (this.lock) {
                this.lock.notifyAll();
            }
        }

        /**
         * Sets the exception from failed execution and executes callback if available. Notifies any thread waiting for
         * completion.
         *
         * @param exception exception of the failed task
         */
        void setException(final Exception exception) {
            this.exception = exception;
            this.state = FAILED;
            this.callback.ifPresent(ac -> ac.onComplete(null, Optional.of(exception)));
            synchronized (this.lock) {
                this.lock.notifyAll();
            }
        }

        @Override
        public boolean isCompleted() {
            return this.state > RUNNING;
        }

        @Override
        public T getValue() throws ExecutionException {
            if (this.state == COMPLETED) {
                return this.value;
            } else if (this.state == FAILED) {
                throw new ExecutionException(exception);
            }
            throw new IllegalStateException("Execution not completed yet");
        }

        @Override
        public void await() throws InterruptedException {
            synchronized (this.lock) {
                while (!this.isCompleted()) {
                    this.lock.wait();
                }
            }
        }
    }
}
