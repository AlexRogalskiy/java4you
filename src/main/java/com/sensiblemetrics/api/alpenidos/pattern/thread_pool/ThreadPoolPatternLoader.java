package com.sensiblemetrics.api.alpenidos.pattern.thread_pool;

import com.sensiblemetrics.api.alpenidos.pattern.thread_pool.factory.Worker;
import com.sensiblemetrics.api.alpenidos.pattern.thread_pool.impl.CoffeeMakingTask;
import com.sensiblemetrics.api.alpenidos.pattern.thread_pool.impl.PotatoPeelingTask;
import com.sensiblemetrics.api.alpenidos.pattern.thread_pool.impl.Task;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.extern.slf4j.Slf4j;

/**
 * Thread Pool pattern is where a number of threads are created to perform a number of tasks, which are usually organized in a queue. The results from the tasks
 * being executed might also be placed in a queue, or the tasks might return no result. Typically, there are many more tasks than threads. As soon as a thread
 * completes its task, it will request the next task from the queue until all tasks have been completed. The thread can then terminate, or sleep until there are
 * new tasks available.
 * <p>
 * In this example we create a list of tasks presenting work to be done. Each task is then wrapped into a {@link Worker} object that implements {@link
 * Runnable}. We create an {@link ExecutorService} with fixed number of threads (Thread Pool) and use them to execute the {@link Worker}s.
 */
@Slf4j
public class ThreadPoolPatternLoader {

    /**
     * Program entry point
     *
     * @param args command line args
     */
    public static void main(final String[] args) {
        log.info("Program started");

        // Create a list of tasks to be executed
        final List<Task> tasks = new ArrayList<>();
        tasks.add(new PotatoPeelingTask(3));
        tasks.add(new PotatoPeelingTask(6));
        tasks.add(new CoffeeMakingTask(2));
        tasks.add(new CoffeeMakingTask(6));
        tasks.add(new PotatoPeelingTask(4));
        tasks.add(new CoffeeMakingTask(2));
        tasks.add(new PotatoPeelingTask(4));
        tasks.add(new CoffeeMakingTask(9));
        tasks.add(new PotatoPeelingTask(3));
        tasks.add(new CoffeeMakingTask(2));
        tasks.add(new PotatoPeelingTask(4));
        tasks.add(new CoffeeMakingTask(2));
        tasks.add(new CoffeeMakingTask(7));
        tasks.add(new PotatoPeelingTask(4));
        tasks.add(new PotatoPeelingTask(5));

        // Creates a thread pool that reuses a fixed number of threads operating off a shared
        // unbounded queue. At any point, at most nThreads threads will be active processing
        // tasks. If additional tasks are submitted when all threads are active, they will wait
        // in the queue until a thread is available.
        final ExecutorService executor = Executors.newFixedThreadPool(3);

        // Allocate new worker for each task
        // The worker is executed when a thread becomes
        // available in the thread pool
        for (final Task task : tasks) {
            final Runnable worker = new Worker(task);
            executor.execute(worker);
        }

        // All tasks were executed, now shutdown
        executor.shutdown();
        while (!executor.isTerminated()) {
            Thread.yield();
        }

        log.info("Program finished");
    }
}
