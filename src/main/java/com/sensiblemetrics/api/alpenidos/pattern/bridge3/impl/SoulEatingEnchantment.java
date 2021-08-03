package com.sensiblemetrics.api.alpenidos.pattern.bridge3.impl;

import com.sensiblemetrics.api.alpenidos.pattern.bridge3.iface.Enchantment;
import lombok.extern.slf4j.Slf4j;

/**
 * SoulEatingEnchantment
 */
@Slf4j
public class SoulEatingEnchantment implements Enchantment {

    @Override
    public void onActivate() {
        log.info("The item spreads bloodlust.");
    }

    @Override
    public void apply() {
        log.info("The item eats the soul of enemies.");
    }

    @Override
    public void onDeactivate() {
        log.info("Bloodlust slowly disappears.");
    }
}
