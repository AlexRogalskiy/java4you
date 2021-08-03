package com.sensiblemetrics.api.alpenidos.pattern.queue_load_leveling;

import com.sensiblemetrics.api.alpenidos.pattern.queue_load_leveling.impl.MessageQueue;
import com.sensiblemetrics.api.alpenidos.pattern.queue_load_leveling.impl.TaskGenerator;
import com.sensiblemetrics.api.alpenidos.pattern.queue_load_leveling.model.Message;
import com.sensiblemetrics.api.alpenidos.pattern.queue_load_leveling.service.ServiceExecutor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Many solutions in the cloud involve running tasks that invoke services. In this environment,
 * if a service is subjected to intermittent heavy loads, it can cause performance or reliability issues.
 * <p>
 * A service could be a component that is part of the same solution as the tasks that utilize it, or it
 * could be a third-party service providing access to frequently used resources such as a cache or a storage service.
 * If the same service is utilized by a number of tasks running concurrently, it can be difficult to predict the
 * volume of requests to which the service might be subjected at any given point in time.
 * <p>
 * We will build a queue-based-load-leveling to solve above problem.
 * Refactor the solution and introduce a queue between the task and the service.
 * The task and the service run asynchronously. The task posts a message containing the data required
 * by the service to a queue. The queue acts as a buffer, storing the message until it is retrieved
 * by the service. The service retrieves the messages from the queue and processes them.
 * Requests from a number of tasks, which can be generated at a highly variable rate, can be passed
 * to the service through the same message queue.
 * <p>
 * The queue effectively decouples the tasks from the service, and the service can handle the messages
 * at its own pace irrespective of the volume of requests from concurrent tasks. Additionally,
 * there is no delay to a task if the service is not available at the time it posts a message to the queue.
 * <p>
 * In this example we have a class {@link MessageQueue} to hold the message {@link Message} objects.
 * All the worker threads {@link TaskGenerator} will submit the messages to the MessageQueue.
 * The service executor class {@link ServiceExecutor} will pick up one task at a time from the Queue and
 * execute them.
 */
@Slf4j
public class QueueLoadLevelingPatternLoader {
    //Executor shut down time limit.
    private static final int SHUTDOWN_TIME = 15;

    /**
     * Program entry point
     *
     * @param args command line args
     */
    public static void main(final String[] args) {
        // An Executor that provides methods to manage termination and methods that can
        // produce a Future for tracking progress of one or more asynchronous tasks.
        ExecutorService executor = null;

        try {
            // Create a MessageQueue object.
            final MessageQueue msgQueue = new MessageQueue();
            log.info("Submitting TaskGenerators and ServiceExecutor threads.");

            // Create three TaskGenerator threads. Each of them will submit different number of jobs.
            final Runnable taskRunnable1 = new TaskGenerator(msgQueue, 5);
            final Runnable taskRunnable2 = new TaskGenerator(msgQueue, 1);
            final Runnable taskRunnable3 = new TaskGenerator(msgQueue, 2);

            // Create e service which should process the submitted jobs.
            final Runnable srvRunnable = new ServiceExecutor(msgQueue);

            // Create a ThreadPool of 2 threads and
            // submit all Runnable task for execution to executor..
            executor = Executors.newFixedThreadPool(2);
            executor.submit(taskRunnable1);
            executor.submit(taskRunnable2);
            executor.submit(taskRunnable3);

            // submitting serviceExecutor thread to the Executor service.
            executor.submit(srvRunnable);

            // Initiates an orderly shutdown.
            log.info("Intiating shutdown. Executor will shutdown only after all the Threads are completed.");
            executor.shutdown();

            // Wait for SHUTDOWN_TIME seconds for all the threads to complete
            // their tasks and then shut down the executor and then exit.
            if (!executor.awaitTermination(SHUTDOWN_TIME, TimeUnit.SECONDS)) {
                log.info("Executor was shut down and Exiting.");
                executor.shutdownNow();
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
