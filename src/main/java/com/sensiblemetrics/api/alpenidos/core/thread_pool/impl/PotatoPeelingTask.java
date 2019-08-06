package com.sensiblemetrics.api.alpenidos.core.thread_pool.impl;

/**
 * PotatoPeelingTask is a concrete task
 */
public class PotatoPeelingTask extends Task {

    private static final int TIME_PER_POTATO = 200;

    public PotatoPeelingTask(final int numPotatoes) {
        super(numPotatoes * TIME_PER_POTATO);
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.getClass().getSimpleName(), super.toString());
    }
}
