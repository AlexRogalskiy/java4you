package com.sensiblemetrics.api.alpenidos.core.template_method2.impl;

import lombok.extern.slf4j.Slf4j;

/**
 * StealingMethod defines skeleton for the algorithm.
 */
@Slf4j
public abstract class StealingMethod {

    protected abstract String pickTarget();

    protected abstract void confuseTarget(String target);

    protected abstract void stealTheItem(String target);

    /**
     * Steal
     */
    public void steal() {
        final String target = this.pickTarget();
        log.info("The target has been chosen as {}.", target);
        this.confuseTarget(target);
        this.stealTheItem(target);
    }
}
