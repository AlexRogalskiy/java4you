package com.sensiblemetrics.api.alpenidos.pattern.task_execution;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Pattern: Background Task Executor
 * <p>
 * Motivation: Executing tasks outside the main thread is useful when some task
 * may take a long time to run and you don't want to wait for it to end.
 * <p>
 * Intent: Create a Background task executor with the ability to execute and
 * cancel tasks.
 * <p>
 * Applicability: Sending an email after a user registration in your web-app; or
 * executing a long running task in background; use the Background Task Executor
 * to not compromise the main thread or the current thread you're using.
 */
public class BackgroundTaskExecutor {

    public interface OnInterruption<T> {
        void accept(final Future<T> future, final Exception exception);
    }

    public interface OnShutdownError {
        void accept(final ExecutorService executor, final Exception exception);
    }

    private final ExecutorService executor;

    public BackgroundTaskExecutor(int threadsForTasks) {
        this.executor = Executors.newFixedThreadPool(threadsForTasks);
    }

    public <T> Future<T> execute(final Callable<T> task) {
        var submited = this.executor.submit(task);
        return submited;
    }

    public <T> List<Future<T>> execute(final List<Callable<T>> tasks) {
        var futureTasks = tasks.stream()
            .map(this.executor::submit)
            .collect(Collectors.toList());
        return futureTasks;
    }

    public <T> boolean cancel(final Future<T> task) {
        var canceled = task.cancel(true);
        return canceled;
    }

    public <T> boolean cancel(final List<FutureTask<T>> task) {
        var hasAFalse = task.stream()
            .map(f -> f.cancel(true))
            .anyMatch(b -> b.equals(false));
        return !hasAFalse;
    }

    public <T> List<Optional<T>> completeTask(final List<Future<T>> tasks, final OnInterruption<T> onInterruption) {
        final Function<Future<T>, Optional<T>> operator = (task) -> {
            try {
                return Optional.ofNullable(task.get());
            } catch (InterruptedException | ExecutionException e) {
                onInterruption.accept(task, e);
                return Optional.empty();
            }
        };
        var results = tasks.stream()
            .map(operator)
            .collect(Collectors.toList());
        return results;
    }

    public <T> Optional<T> completeTask(final Future<T> task, final OnInterruption<T> onInterruption) {
        try {
            return Optional.ofNullable(task.get());
        } catch (InterruptedException | ExecutionException e) {
            onInterruption.accept(task, e);
            return Optional.empty();
        }
    }

    public void shutdownTasks(final long timeout, final TimeUnit timeUnit, final OnShutdownError onShutdownError) {
        this.executor.shutdown();
        try {
            this.executor.awaitTermination(timeout, timeUnit);
        } catch (InterruptedException e) {
            onShutdownError.accept(this.executor, e);
        }
    }

    public List<Runnable> shutdownNowTasks(final long timeout, final TimeUnit timeUnit, final OnShutdownError onShutdownError) {
        var remainingTasks = this.executor.shutdownNow();
        try {
            this.executor.awaitTermination(timeout, timeUnit);
        } catch (InterruptedException e) {
            onShutdownError.accept(this.executor, e);
        }
        return remainingTasks;
    }
}
