package com.sensiblemetrics.api.alpenidos.pattern.object_pool2.impl;

import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Oliphaunts are expensive to create
 */
@Data
public class Oliphaunt {
    private static AtomicInteger counter = new AtomicInteger(0);

    private final int id;

    /**
     * Constructor
     */
    public Oliphaunt() {
        this.id = counter.incrementAndGet();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return String.format("Oliphaunt id=%d", this.id);
    }
}
