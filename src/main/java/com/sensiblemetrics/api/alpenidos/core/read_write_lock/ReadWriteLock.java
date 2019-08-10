package com.sensiblemetrics.api.alpenidos.core.read_write_lock;

import java.util.ArrayList;
import java.util.List;

/**
 * Based on: "Patterns in Java", Mark Grand.
 */
public class ReadWriteLock {
    private List<Thread> waitingForWriteLock = new ArrayList<>();
    private int waitingForReadLock = 0;
    private int outstandingReadLocks = 0;
    private Thread writeLockedThread;

    public synchronized void readLock() throws InterruptedException {
        if (this.writeLockedThread != null) {
            this.waitingForReadLock++;
            while (this.writeLockedThread != null) {
                this.wait();
            }
            this.waitingForReadLock--;
        }
        outstandingReadLocks++;
    }

    public void writeLock() throws InterruptedException {
        Thread thisThread;
        synchronized (this) {
            if (this.writeLockedThread == null && this.outstandingReadLocks == 0) {
                this.writeLockedThread = Thread.currentThread();
                return;
            }
            thisThread = Thread.currentThread();
            this.waitingForWriteLock.add(thisThread);
        }

        synchronized (thisThread) {
            while (thisThread != this.writeLockedThread) {
                thisThread.wait();
            }
            synchronized (this) {
                this.waitingForWriteLock.remove(thisThread);
            }
        }
    }

    public synchronized void done() {
        if (this.outstandingReadLocks > 0) {
            this.outstandingReadLocks--;
            if (this.outstandingReadLocks == 0 && this.waitingForWriteLock.size() > 0) {
                this.writeLockedThread = this.waitingForWriteLock.get(0);
                this.writeLockedThread.notifyAll();
            }
        } else if (Thread.currentThread() == this.writeLockedThread) {
            if (this.outstandingReadLocks == 0 && this.waitingForWriteLock.size() > 0) {
                this.writeLockedThread = this.waitingForWriteLock.get(0);
                this.writeLockedThread.notifyAll();
            }
        } else {
            this.writeLockedThread = null;
            if (this.waitingForReadLock > 0) {
                this.notifyAll();
            } else {
                throw new IllegalStateException("Thread doesn't have lock");
            }
        }
    }
}
