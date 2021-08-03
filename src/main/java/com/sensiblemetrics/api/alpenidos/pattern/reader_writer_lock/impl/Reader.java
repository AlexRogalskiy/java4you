package com.sensiblemetrics.api.alpenidos.pattern.reader_writer_lock.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Lock;

/**
 * Reader class, read when it acquired the read lock
 */
@Slf4j
@AllArgsConstructor
public class Reader implements Runnable {
    private String name;
    private Lock readLock;
    private long readingTime;

    /**
     * Create new Reader who reads for 250ms
     *
     * @param name     - Name of the thread owning the reader
     * @param readLock - Lock for this reader
     */
    public Reader(final String name, final Lock readLock) {
        this(name, readLock, 250L);
    }

    @Override
    public void run() {
        this.readLock.lock();
        try {
            this.read();
        } catch (InterruptedException e) {
            log.info("InterruptedException when reading", e);
            Thread.currentThread().interrupt();
        } finally {
            this.readLock.unlock();
        }
    }

    /**
     * Simulate the read operation
     */
    public void read() throws InterruptedException {
        log.info("{} begin", name);
        Thread.sleep(readingTime);
        log.info("{} finish after reading {}ms", name, readingTime);
    }
}
