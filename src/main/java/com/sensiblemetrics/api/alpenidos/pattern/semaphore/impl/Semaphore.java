package com.sensiblemetrics.api.alpenidos.pattern.semaphore.impl;

import com.sensiblemetrics.api.alpenidos.pattern.semaphore.iface.Lock;

/**
 * Semaphore is an implementation of a semaphore lock.
 */
public class Semaphore implements Lock {

    private final int licenses;
    /**
     * The number of concurrent resource accesses which are allowed.
     */
    private int counter;

    public Semaphore(final int licenses) {
        this.licenses = licenses;
        this.counter = licenses;
    }

    /**
     * Returns the number of licenses managed by the Semaphore
     */
    public int getNumLicenses() {
        return this.licenses;
    }

    /**
     * Returns the number of available licenses
     */
    public int getAvailableLicenses() {
        return this.counter;
    }

    /**
     * Method called by a thread to acquire the lock. If there are no resources
     * available this will wait until the lock has been released to re-attempt
     * the acquire.
     */
    public synchronized void acquire() throws InterruptedException {
        while (this.counter == 0) {
            this.wait();
        }
        this.counter = this.counter - 1;
    }

    /**
     * Method called by a thread to release the lock.
     */
    public synchronized void release() {
        if (this.counter < this.licenses) {
            this.counter = this.counter + 1;
            this.notify();
        }
    }
}
