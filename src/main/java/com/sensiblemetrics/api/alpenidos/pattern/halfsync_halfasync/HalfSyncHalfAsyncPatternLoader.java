package com.sensiblemetrics.api.alpenidos.pattern.halfsync_halfasync;

import com.sensiblemetrics.api.alpenidos.pattern.halfsync_halfasync.iface.AsyncTask;
import com.sensiblemetrics.api.alpenidos.pattern.halfsync_halfasync.impl.AsynchronousService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * This application demonstrates Half-Sync/Half-Async pattern. Key parts of the pattern are
 * {@link AsyncTask} and {@link AsynchronousService}.
 *
 * <p>
 * <i>PROBLEM</i> <br>
 * A concurrent system have a mixture of short duration, mid duration and long duration tasks. Mid
 * or long duration tasks should be performed asynchronously to meet quality of service
 * requirements.
 *
 * <p>
 * <i>INTENT</i> <br>
 * The intent of this pattern is to separate the the synchronous and asynchronous processing in the
 * concurrent application by introducing two intercommunicating layers - one for sync and one for
 * async. This simplifies the programming without unduly affecting the performance.
 *
 * <p>
 * <i>APPLICABILITY</i> <br>
 * UNIX network subsystems - In operating systems network operations are carried out
 * asynchronously with help of hardware level interrupts.<br>
 * CORBA - At the asynchronous layer one thread is associated with each socket that is connected
 * to the client. Thread blocks waiting for CORBA requests from the client. On receiving request it
 * is inserted in the queuing layer which is then picked up by synchronous layer which processes the
 * request and sends response back to the client.<br>
 * Android AsyncTask framework - Framework provides a way to execute long running blocking
 * calls, such as downloading a file, in background threads so that the UI thread remains free to
 * respond to user inputs.<br>
 *
 * <p>
 * <i>IMPLEMENTATION</i> <br>
 * The main method creates an asynchronous service which does not block the main thread while the
 * task is being performed. The main thread continues its work which is similar to Async Method
 * Invocation pattern. The difference between them is that there is a queuing layer between
 * Asynchronous layer and synchronous layer, which allows for different communication patterns
 * between both layers. Such as Priority Queue can be used as queuing layer to prioritize the way
 * tasks are executed. Our implementation is just one simple way of implementing this pattern, there
 * are many variants possible as described in its applications.
 */
@Slf4j
public class HalfSyncHalfAsyncPatternLoader {

    /**
     * Program entry point
     *
     * @param args command line args
     */
    public static void main(final String[] args) {
        final AsynchronousService service = new AsynchronousService(new LinkedBlockingQueue<>());

        /*
         * A new task to calculate sum is received but as this is main thread, it should not block. So
         * it passes it to the asynchronous task layer to compute and proceeds with handling other
         * incoming requests. This is particularly useful when main thread is waiting on Socket to
         * receive new incoming requests and does not wait for particular request to be completed before
         * responding to new request.
         */
        service.execute(new ArithmeticSumTask(1000));
        /*
         * New task received, lets pass that to async layer for computation. So both requests will be
         * executed in parallel.
         */
        service.execute(new ArithmeticSumTask(500));
        service.execute(new ArithmeticSumTask(2000));
        service.execute(new ArithmeticSumTask(1));
    }

    /**
     * ArithmeticSumTask
     */
    @RequiredArgsConstructor
    public static class ArithmeticSumTask implements AsyncTask<Long> {
        private final long n;

        /*
         * This is the long running task that is performed in background. In our example the long
         * running task is calculating arithmetic sum with artificial delay.
         */
        @Override
        public Long call() {
            return ap(n);
        }

        /*
         * This will be called in context of the main thread where some validations can be done
         * regarding the inputs. Such as it must be greater than 0. It's a small computation which can
         * be performed in main thread. If we did validated the input in background thread then we pay
         * the cost of context switching which is much more than validating it in main thread.
         */
        @Override
        public void onPreCall() {
            if (n < 0) {
                throw new IllegalArgumentException("n is less than 0");
            }
        }

        @Override
        public void onPostCall(final Long result) {
            // Handle the result of computation
            log.info(String.valueOf(result));
        }

        @Override
        public void onError(final Throwable throwable) {
            throw new IllegalStateException("Should not occur");
        }
    }

    private static long ap(long i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            log.error("Exception caught.", e);
        }
        return i * (i + 1) / 2;
    }
}
