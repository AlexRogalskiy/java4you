package com.sensiblemetrics.api.alpenidos.core.reader_writer_lock;

import com.sensiblemetrics.api.alpenidos.core.reader_writer_lock.impl.Reader;
import com.sensiblemetrics.api.alpenidos.core.reader_writer_lock.impl.ReaderWriterLock;
import com.sensiblemetrics.api.alpenidos.core.reader_writer_lock.impl.Writer;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * In a multiple thread applications, the threads may try to synchronize the shared resources
 * regardless of read or write operation. It leads to a low performance especially in a "read more
 * write less" system as indeed the read operations are thread-safe to another read operation.
 * <p>
 * Reader writer lock is a synchronization primitive that try to resolve this problem. This pattern
 * allows concurrent access for read-only operations, while write operations require exclusive
 * access. This means that multiple threads can read the data in parallel but an exclusive lock is
 * needed for writing or modifying data. When a writer is writing the data, all other writers or
 * readers will be blocked until the writer is finished writing.
 *
 * <p>
 * This example use two mutex to demonstrate the concurrent access of multiple readers and writers.
 */
@Slf4j
public class ReaderWriterLockPatternLoader {

    /**
     * Program entry point
     *
     * @param args command line args
     */
    public static void main(final String[] args) {
        final ExecutorService executeService = Executors.newFixedThreadPool(10);
        final ReaderWriterLock lock = new ReaderWriterLock();

        // Start writers
        IntStream.range(0, 5)
            .forEach(i -> executeService.submit(
                new Writer("Writer " + i, lock.writeLock(), ThreadLocalRandom.current().nextLong(5000))
            ));
        log.info("Writers added...");

        // Start readers
        IntStream.range(0, 5)
            .forEach(i -> executeService.submit(
                new Reader("Reader " + i, lock.readLock(), ThreadLocalRandom.current().nextLong(10))
            ));
        log.info("Readers added...");

        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            log.error("Error sleeping before adding more readers", e);
            Thread.currentThread().interrupt();
        }

        // Start readers
        IntStream.range(6, 10)
            .forEach(i -> executeService.submit(
                new Reader("Reader " + i, lock.readLock(), ThreadLocalRandom.current().nextLong(10))
            ));
        log.info("More readers added...");


        // In the system console, it can see that the read operations are executed concurrently while
        // write operations are exclusive.
        executeService.shutdown();
        try {
            executeService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error("Error waiting for ExecutorService shutdown", e);
            Thread.currentThread().interrupt();
        }
    }
}
