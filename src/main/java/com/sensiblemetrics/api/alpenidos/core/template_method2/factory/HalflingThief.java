package com.sensiblemetrics.api.alpenidos.core.template_method2.factory;

import com.sensiblemetrics.api.alpenidos.core.template_method2.impl.StealingMethod;

/**
 * Halfling thief uses {@link StealingMethod} to steal.
 */
public class HalflingThief {
    private StealingMethod method;

    public HalflingThief(final StealingMethod method) {
        this.method = method;
    }

    public void steal() {
        this.method.steal();
    }

    public void changeMethod(final StealingMethod method) {
        this.method = method;
    }
}
