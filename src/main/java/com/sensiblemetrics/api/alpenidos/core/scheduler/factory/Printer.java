package com.sensiblemetrics.api.alpenidos.core.scheduler.factory;

import com.sensiblemetrics.api.alpenidos.core.scheduler.impl.JournalEntry;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * <p>
 * Date: Aug 22, 2011
 *
 * @author moleksyuk
 */
public class Printer {
    private Scheduler scheduler = new Scheduler();

    public void print(final JournalEntry j) {
        try {
            this.scheduler.enter(j);
            try {
                // ...
            } finally {
                this.scheduler.done();
            }
        } catch (InterruptedException e) {
        }
    }
}
