package com.sensiblemetrics.api.alpenidos.pattern.producer_consumer2.dispatcher;

import com.sensiblemetrics.api.alpenidos.pattern.producer_consumer2.model.TroubleTicket;

import java.util.ArrayList;
import java.util.List;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * <p>
 * Date: Aug 19, 2011
 *
 * @author moleksyuk
 */
public class Queue {
    private final List<TroubleTicket> data = new ArrayList<>();

    public synchronized void push(final TroubleTicket tck) {
        this.data.add(tck);
        notify();
    }

    public synchronized TroubleTicket pull() {
        while (this.data.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        final TroubleTicket tck = this.data.get(0);
        this.data.remove(0);
        return tck;
    }

    public int size() {
        return this.data.size();
    }
}
