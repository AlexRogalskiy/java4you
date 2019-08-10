package com.sensiblemetrics.api.alpenidos.core.read_write_lock;

/**
 * Based on: "Patterns in Java", Mark Grand.
 */
public class Bid {
    private ReadWriteLock lockManager = new ReadWriteLock();
    private int bid = 0;

    public int getBid() throws InterruptedException {
        this.lockManager.readLock();
        final int bid = this.bid;
        this.lockManager.done();
        return bid;
    }

    public void setBid(int bid) throws InterruptedException {
        this.lockManager.writeLock();
        if (bid > this.bid) {
            this.bid = bid;
        }
        this.lockManager.done();
    }
}
