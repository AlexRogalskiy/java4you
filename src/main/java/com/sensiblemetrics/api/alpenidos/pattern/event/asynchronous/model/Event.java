package com.sensiblemetrics.api.alpenidos.pattern.event.asynchronous.model;

import com.sensiblemetrics.api.alpenidos.pattern.event.asynchronous.iface.IEvent;
import com.sensiblemetrics.api.alpenidos.pattern.event.asynchronous.iface.ThreadCompleteListener;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Each Event runs as a separate/individual thread.
 */
@Slf4j
public class Event implements IEvent, Runnable {
    private int eventId;
    private int eventTime;
    private boolean isSynchronous;
    private Thread thread;
    private boolean isComplete = false;
    private List<ThreadCompleteListener> eventListeners;

    /**
     * @param eventId       event ID
     * @param eventTime     event time
     * @param isSynchronous is of synchronous type
     */
    public Event(final int eventId, final int eventTime, final boolean isSynchronous) {
        this.eventId = eventId;
        this.eventTime = eventTime;
        this.isSynchronous = isSynchronous;
        this.eventListeners = new ArrayList<>();
    }

    public boolean isSynchronous() {
        return this.isSynchronous;
    }

    @Override
    public void start() {
        this.thread = new Thread(this);
        this.thread.start();
    }

    @Override
    public void stop() {
        if (null == this.thread) {
            return;
        }
        thread.interrupt();
    }

    @Override
    public void status() {
        if (!this.isComplete) {
            log.info("[{}] is not done.", this.eventId);
        } else {
            log.info("[{}] is done.", this.eventId);
        }
    }

    @Override
    public void run() {
        final long currentTime = System.currentTimeMillis();
        final long endTime = currentTime + (this.eventTime * 1000);
        while (System.currentTimeMillis() < endTime) {
            try {
                Thread.sleep(1000); // Sleep for 1 second.
            } catch (InterruptedException e) {
                return;
            }
        }
        this.isComplete = true;
        completed();
    }

    public final void addListener(final ThreadCompleteListener listener) {
        this.eventListeners.add(listener);
    }

    public final void removeListener(final ThreadCompleteListener listener) {
        this.eventListeners.remove(listener);
    }

    private final void completed() {
        this.eventListeners.forEach(e -> e.completedEventHandler(this.eventId));
    }
}
