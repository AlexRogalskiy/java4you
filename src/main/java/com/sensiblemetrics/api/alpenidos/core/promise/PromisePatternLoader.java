package com.sensiblemetrics.api.alpenidos.core.promise;

import com.sensiblemetrics.api.alpenidos.core.promise.impl.Promise;
import com.sensiblemetrics.api.alpenidos.core.promise.utils.Utility;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.*;

/**
 * The Promise object is used for asynchronous computations. A Promise represents an operation
 * that hasn't completed yet, but is expected in the future.
 *
 * <p>A Promise represents a proxy for a value not necessarily known when the promise is created. It
 * allows you to associate dependent promises to an asynchronous action's eventual success value or
 * failure reason. This lets asynchronous methods return values like synchronous methods: instead
 * of the final value, the asynchronous method returns a promise of having a value at some point
 * in the future.
 *
 * <p>Promises provide a few advantages over callback objects:
 * <ul>
 * <li> Functional composition and error handling
 * <li> Prevents callback hell and provides callback aggregation
 * </ul>
 *
 * <p>
 * In this application the usage of promise is demonstrated with two examples:
 * <ul>
 * <li>Count Lines: In this example a file is downloaded and its line count is calculated.
 * The calculated line count is then consumed and printed on console.
 * <li>Lowest Character Frequency: In this example a file is downloaded and its lowest frequency
 * character is found and printed on console. This happens via a chain of promises, we start with
 * a file download promise, then a promise of character frequency, then a promise of lowest frequency
 * character which is finally consumed and result is printed on console.
 * </ul>
 *
 * @see CompletableFuture
 */
@Slf4j
public class PromisePatternLoader {
    private static final String DEFAULT_URL = "https://raw.githubusercontent.com/iluwatar/java-design-patterns/master/promise/README.md";
    private final ExecutorService executor;
    private final CountDownLatch stopLatch;

    private PromisePatternLoader() {
        this.executor = Executors.newFixedThreadPool(2);
        this.stopLatch = new CountDownLatch(2);
    }

    /**
     * Program entry point
     *
     * @param args arguments
     * @throws InterruptedException if main thread is interrupted.
     * @throws ExecutionException   if an execution error occurs.
     */
    public static void main(final String[] args) throws InterruptedException, ExecutionException {
        final PromisePatternLoader app = new PromisePatternLoader();
        try {
            app.promiseUsage();
        } finally {
            app.stop();
        }
    }

    private void promiseUsage() {
        this.calculateLineCount();
        this.calculateLowestFrequencyChar();
    }

    /*
     * Calculate the lowest frequency character and when that promise is fulfilled,
     * consume the result in a Consumer<Character>
     */
    private void calculateLowestFrequencyChar() {
        lowestFrequencyChar()
            .thenAccept(
                charFrequency -> {
                    log.info("Char with lowest frequency is: {}", charFrequency);
                    this.taskCompleted();
                }
            );
    }

    /*
     * Calculate the line count and when that promise is fulfilled, consume the result
     * in a Consumer<Integer>
     */
    private void calculateLineCount() {
        countLines()
            .thenAccept(
                count -> {
                    log.info("Line count is: {}", count);
                    this.taskCompleted();
                }
            );
    }

    /*
     * Calculate the character frequency of a file and when that promise is fulfilled,
     * then promise to apply function to calculate lowest character frequency.
     */
    private Promise<Character> lowestFrequencyChar() {
        return this.characterFrequency().thenApply(Utility::lowestFrequencyChar);
    }

    /*
     * Download the file at DEFAULT_URL and when that promise is fulfilled,
     * then promise to apply function to calculate character frequency.
     */
    private Promise<Map<Character, Integer>> characterFrequency() {
        return this.download(DEFAULT_URL).thenApply(Utility::characterFrequency);
    }

    /*
     * Download the file at DEFAULT_URL and when that promise is fulfilled,
     * then promise to apply function to count lines in that file.
     */
    private Promise<Integer> countLines() {
        return this.download(DEFAULT_URL).thenApply(Utility::countLines);
    }

    /*
     * Return a promise to provide the local absolute path of the file downloaded in background.
     * This is an async method and does not wait until the file is downloaded.
     */
    private Promise<String> download(String urlString) {
        return new Promise<String>()
            .fulfillInAsync(
                () -> Utility.downloadFile(urlString), executor)
            .onError(
                throwable -> {
                    throwable.printStackTrace();
                    taskCompleted();
                }
            );
    }

    private void stop() throws InterruptedException {
        this.stopLatch.await();
        this.executor.shutdownNow();
    }

    private void taskCompleted() {
        this.stopLatch.countDown();
    }
}
