package com.sensiblemetrics.api.alpenidos.pattern.bridge3.impl;

import com.sensiblemetrics.api.alpenidos.pattern.bridge3.iface.Enchantment;
import lombok.extern.slf4j.Slf4j;

/**
 * FlyingEnchantment
 */
@Slf4j
public class FlyingEnchantment implements Enchantment {

    @Override
    public void onActivate() {
        log.info("The item begins to glow faintly.");
    }

    @Override
    public void apply() {
        log.info("The item flies and strikes the enemies finally returning to owner's hand.");
    }

    @Override
    public void onDeactivate() {
        log.info("The item's glow fades.");
    }
}
