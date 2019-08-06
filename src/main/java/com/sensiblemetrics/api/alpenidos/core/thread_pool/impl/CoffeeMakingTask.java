package com.sensiblemetrics.api.alpenidos.core.thread_pool.impl;

/**
 * CoffeeMakingTask is a concrete task
 */
public class CoffeeMakingTask extends Task {

    private static final int TIME_PER_CUP = 100;

    public CoffeeMakingTask(final int numCups) {
        super(numCups * TIME_PER_CUP);
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.getClass().getSimpleName(), super.toString());
    }
}
