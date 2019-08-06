package com.sensiblemetrics.api.alpenidos.core.template_method2.impl;

import com.sensiblemetrics.api.alpenidos.core.template_method2.impl.StealingMethod;
import lombok.extern.slf4j.Slf4j;

/**
 * HitAndRunMethod implementation of {@link StealingMethod}.
 */
@Slf4j
public class HitAndRunMethod extends StealingMethod {

    @Override
    protected String pickTarget() {
        return "old goblin woman";
    }

    @Override
    protected void confuseTarget(final String target) {
        log.info("Approach the {} from behind.", target);
    }

    @Override
    protected void stealTheItem(final String target) {
        log.info("Grab the handbag and run away fast!");
    }
}
