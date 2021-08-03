package com.sensiblemetrics.api.alpenidos.pattern.semaphore2;

/**
 * Although java.util.concurrent has its own semaphore class, this is a simpler implementation of a semaphore
 */
public class Semaphore {

    /**
     * Semaphore's count, it represent how many threads can access the resource at the same time
     */
    private int count;

    public Semaphore(final int count) {
        this.count = count;
    }

    public synchronized void acquire() {
        this.count--;
        if (this.count < 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void release() {
        this.count++;
        if (count <= 0) {
            this.notify();
        }
    }
}
