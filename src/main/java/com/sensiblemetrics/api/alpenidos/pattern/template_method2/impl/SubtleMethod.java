package com.sensiblemetrics.api.alpenidos.pattern.template_method2.impl;

import lombok.extern.slf4j.Slf4j;

/**
 * SubtleMethod implementation of {@link StealingMethod}.
 */
@Slf4j
public class SubtleMethod extends StealingMethod {

    @Override
    protected String pickTarget() {
        return "shop keeper";
    }

    @Override
    protected void confuseTarget(final String target) {
        log.info("Approach the {} with tears running and hug him!", target);
    }

    @Override
    protected void stealTheItem(final String target) {
        log.info("While in close contact grab the {}'s wallet.", target);
    }
}
