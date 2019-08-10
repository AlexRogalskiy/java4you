package com.sensiblemetrics.api.alpenidos.core.balking2;

/**
 * Based on: "Patterns in Java", Mark Grand.
 */
public class Flusher {
    private boolean flushInProgress = false;

    public void flush() {
        synchronized (this) {
            if (this.flushInProgress)
                return;
            this.flushInProgress = true;
        }

        System.out.println("Flush water");
    }

    void flushCompleted() {
        this.flushInProgress = false;
    }
}
