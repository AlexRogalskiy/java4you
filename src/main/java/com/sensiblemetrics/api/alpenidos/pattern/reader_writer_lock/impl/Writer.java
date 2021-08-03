package com.sensiblemetrics.api.alpenidos.pattern.reader_writer_lock.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Lock;

/**
 * Writer class, write when it acquired the write lock
 */
@Slf4j
@RequiredArgsConstructor
public class Writer implements Runnable {
    private final String name;
    private final Lock writeLock;
    private final long writingTime;

    /**
     * Create new Writer who writes for 250ms
     *
     * @param name      - Name of the thread owning the writer
     * @param writeLock - Lock for this writer
     */
    public Writer(final String name, final Lock writeLock) {
        this(name, writeLock, 250L);
    }

    @Override
    public void run() {
        this.writeLock.lock();
        try {
            this.write();
        } catch (InterruptedException e) {
            log.info("InterruptedException when writing", e);
            Thread.currentThread().interrupt();
        } finally {
            this.writeLock.unlock();
        }
    }

    /**
     * Simulate the write operation
     */
    public void write() throws InterruptedException {
        log.info("{} begin", this.name);
        Thread.sleep(this.writingTime);
        log.info("{} finished after writing {}ms", this.name, this.writingTime);
    }
}
