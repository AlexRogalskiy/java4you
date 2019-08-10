package com.sensiblemetrics.api.alpenidos.core.scheduler.factory;

import com.sensiblemetrics.api.alpenidos.core.scheduler.iface.ScheduleOrdering;

import java.util.ArrayList;
import java.util.List;

/**
 * Based on: "Patterns in Java", Mark Grand.
 */
public class Scheduler {
    private Thread runningThread;
    private List<ScheduleOrdering> waitingRequests = new ArrayList<>();
    private List<Thread> waitingThreads = new ArrayList<>();

    public void enter(final ScheduleOrdering s) throws InterruptedException {
        final Thread thisThread = Thread.currentThread();
        synchronized (this) {
            if (this.runningThread == null) {
                this.runningThread = thisThread;
                return;
            }
            this.waitingThreads.add(thisThread);
            this.waitingRequests.add(s);
        }

        synchronized (thisThread) {
            while (thisThread != this.runningThread) {
                thisThread.wait();
            }
        }

        synchronized (this) {
            int i = this.waitingThreads.indexOf(thisThread);
            this.waitingThreads.remove(i);
            this.waitingRequests.remove(i);
        }
    }

    public synchronized void done() {
        if (runningThread != Thread.currentThread()) {
            throw new IllegalStateException("Wrong Thread");
        }
        int waitCount = waitingThreads.size();
        if (waitCount <= 0) {
            runningThread = null;
        } else if (waitCount == 1) {
            runningThread = (Thread) waitingThreads.get(0);
            waitingThreads.remove(0);
        } else {
            int next = waitCount - 1;
            ScheduleOrdering nextRequest = waitingRequests.get(next);
            for (int i = waitCount - 2; i >= 0; i--) {
                ScheduleOrdering r = waitingRequests.get(i);
                if (r.scheduleBefore(nextRequest)) {
                    next = i;
                    nextRequest = waitingRequests.get(next);
                }
            }
            runningThread = waitingThreads.get(next);
            synchronized (runningThread) {
                runningThread.notifyAll();
            }
        }
    }
}
