package com.sensiblemetrics.api.alpenidos.core.promise.impl;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * A Promise represents a proxy for a value not necessarily known when the promise is created. It
 * allows you to associate dependent promises to an asynchronous action's eventual success value or
 * failure reason. This lets asynchronous methods return values like synchronous methods: instead
 * of the final value, the asynchronous method returns a promise of having a value at some point
 * in the future.
 *
 * @param <T> type of result.
 */
@NoArgsConstructor
public class Promise<T> extends PromiseSupport<T> {
    private Runnable fulfillmentAction;
    private Consumer<? super Throwable> exceptionHandler;

    /**
     * Fulfills the promise with the provided value.
     *
     * @param value the fulfilled value that can be accessed using {@link #get()}.
     */
    @Override
    public void fulfill(final T value) {
        super.fulfill(value);
        this.postFulfillment();
    }

    /**
     * Fulfills the promise with exception due to error in execution.
     *
     * @param exception the exception will be wrapped in {@link ExecutionException}
     *                  when accessing the value using {@link #get()}.
     */
    @Override
    public void fulfillExceptionally(final Exception exception) {
        super.fulfillExceptionally(exception);
        this.handleException(exception);
        this.postFulfillment();
    }

    private void handleException(final Exception exception) {
        Optional.ofNullable(this.exceptionHandler).ifPresent(e -> e.accept(exception));
    }

    private void postFulfillment() {
        Optional.ofNullable(this.fulfillmentAction).ifPresent(Runnable::run);
    }

    /**
     * Executes the task using the executor in other thread and fulfills the promise returned
     * once the task completes either successfully or with an exception.
     *
     * @param task     the task that will provide the value to fulfill the promise.
     * @param executor the executor in which the task should be run.
     * @return a promise that represents the result of running the task provided.
     */
    public Promise<T> fulfillInAsync(final Callable<T> task, final Executor executor) {
        executor.execute(() -> {
            try {
                this.fulfill(task.call());
            } catch (Exception ex) {
                this.fulfillExceptionally(ex);
            }
        });
        return this;
    }

    /**
     * Returns a new promise that, when this promise is fulfilled normally, is fulfilled with
     * result of this promise as argument to the action provided.
     *
     * @param action action to be executed.
     * @return a new promise.
     */
    public Promise<Void> thenAccept(final Consumer<? super T> action) {
        final Promise<Void> dest = new Promise<>();
        this.fulfillmentAction = new ConsumeAction(this, dest, action);
        return dest;
    }

    /**
     * Set the exception handler on this promise.
     *
     * @param exceptionHandler a consumer that will handle the exception occurred while fulfilling
     *                         the promise.
     * @return this
     */
    public Promise<T> onError(final Consumer<? super Throwable> exceptionHandler) {
        this.exceptionHandler = exceptionHandler;
        return this;
    }

    /**
     * Returns a new promise that, when this promise is fulfilled normally, is fulfilled with
     * result of this promise as argument to the function provided.
     *
     * @param func function to be executed.
     * @return a new promise.
     */
    public <V> Promise<V> thenApply(final Function<? super T, V> func) {
        final Promise<V> dest = new Promise<>();
        this.fulfillmentAction = new TransformAction<V>(this, dest, func);
        return dest;
    }

    /**
     * Accesses the value from source promise and calls the consumer, then fulfills the
     * destination promise.
     */
    @RequiredArgsConstructor
    private class ConsumeAction implements Runnable {
        private final Promise<T> src;
        private final Promise<Void> dest;
        private final Consumer<? super T> action;

        @Override
        public void run() {
            try {
                this.action.accept(this.src.get());
                this.dest.fulfill(null);
            } catch (Throwable throwable) {
                this.dest.fulfillExceptionally((Exception) throwable.getCause());
            }
        }
    }

    /**
     * Accesses the value from source promise, then fulfills the destination promise using the
     * transformed value. The source value is transformed using the transformation function.
     */
    @RequiredArgsConstructor
    private class TransformAction<V> implements Runnable {
        private final Promise<T> src;
        private final Promise<V> dest;
        private final Function<? super T, V> func;

        @Override
        public void run() {
            try {
                this.dest.fulfill(this.func.apply(this.src.get()));
            } catch (Throwable throwable) {
                this.dest.fulfillExceptionally((Exception) throwable.getCause());
            }
        }
    }
}
