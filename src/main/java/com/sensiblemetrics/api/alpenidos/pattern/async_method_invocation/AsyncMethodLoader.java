package com.sensiblemetrics.api.alpenidos.pattern.async_method_invocation;

import com.sensiblemetrics.api.alpenidos.pattern.async_method_invocation.iface.AsyncCallback;
import com.sensiblemetrics.api.alpenidos.pattern.async_method_invocation.iface.AsyncExecutor;
import com.sensiblemetrics.api.alpenidos.pattern.async_method_invocation.iface.AsyncResult;
import com.sensiblemetrics.api.alpenidos.pattern.async_method_invocation.impl.ThreadAsyncExecutor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

/**
 * This application demonstrates the async method invocation pattern. Key parts of the pattern are
 * <code>AsyncResult</code> which is an intermediate container for an asynchronously evaluated value,
 * <code>AsyncCallback</code> which can be provided to be executed on task completion and <code>AsyncExecutor</code>
 * that manages the execution of the async tasks.
 * <p>
 * The main method shows example flow of async invocations. The main thread starts multiple tasks with variable
 * durations and then continues its own work. When the main thread has done it's job it collects the results of the
 * async tasks. Two of the tasks are handled with callbacks, meaning the callbacks are executed immediately when the
 * tasks complete.
 * <p>
 * Noteworthy difference of thread usage between the async results and callbacks is that the async results are collected
 * in the main thread but the callbacks are executed within the worker threads. This should be noted when working with
 * thread pools.
 * <p>
 * Java provides its own implementations of async method invocation pattern. FutureTask, CompletableFuture and
 * ExecutorService are the real world implementations of this pattern. But due to the nature of parallel programming,
 * the implementations are not trivial. This example does not take all possible scenarios into account but rather
 * provides a simple version that helps to understand the pattern.
 *
 * @see AsyncResult
 * @see AsyncCallback
 * @see AsyncExecutor
 * @see java.util.concurrent.FutureTask
 * @see java.util.concurrent.CompletableFuture
 * @see java.util.concurrent.ExecutorService
 */
@Slf4j
public class AsyncMethodLoader {

    /**
     * Program entry point
     */
    public static void main(final String[] args) throws Exception {
        // construct a new executor that will run async tasks
        final AsyncExecutor executor = new ThreadAsyncExecutor();

        // start few async tasks with varying processing times, two last with callback handlers
        final AsyncResult<Integer> asyncResult1 = executor.startProcess(lazyval(10, 500));
        final AsyncResult<String> asyncResult2 = executor.startProcess(lazyval("test", 300));
        final AsyncResult<Long> asyncResult3 = executor.startProcess(lazyval(50L, 700));
        final AsyncResult<Integer> asyncResult4 = executor.startProcess(lazyval(20, 400), callback("Callback result 4"));
        final AsyncResult<String> asyncResult5 = executor.startProcess(lazyval("callback", 600), callback("Callback result 5"));

        // emulate processing in the current thread while async tasks are running in their own threads
        Thread.sleep(350); // Oh boy I'm working hard here
        log("Some hard work done");

        // wait for completion of the tasks
        final Integer result1 = executor.endProcess(asyncResult1);
        final String result2 = executor.endProcess(asyncResult2);
        final Long result3 = executor.endProcess(asyncResult3);

        asyncResult4.await();
        asyncResult5.await();

        // log the results of the tasks, callbacks log immediately when complete
        log("Result 1: " + result1);
        log("Result 2: " + result2);
        log("Result 3: " + result3);
    }

    /**
     * Creates a callable that lazily evaluates to given value with artificial delay.
     *
     * @param value       value to evaluate
     * @param delayMillis artificial delay in milliseconds
     * @return new callable for lazy evaluation
     */
    private static <T> Callable<T> lazyval(final T value, final long delayMillis) {
        return () -> {
            Thread.sleep(delayMillis);
            log("Task completed with: " + value);
            return value;
        };
    }

    /**
     * Creates a simple callback that logs the complete status of the async result.
     *
     * @param name callback name
     * @return new async callback
     */
    private static <T> AsyncCallback<T> callback(final String name) {
        return (value, ex) -> {
            if (ex.isPresent()) {
                log(name + " failed: " + ex.map(Exception::getMessage).orElse(""));
            } else {
                log(name + ": " + value);
            }
        };
    }

    private static void log(final String msg) {
        log.info(msg);
    }
}
