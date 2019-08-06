package com.sensiblemetrics.api.alpenidos.core.strategy3.impl;

import com.sensiblemetrics.api.alpenidos.core.strategy3.iface.DragonSlayingStrategy;
import lombok.extern.slf4j.Slf4j;

/**
 * Spell strategy.
 */
@Slf4j
public class SpellStrategy implements DragonSlayingStrategy {

    @Override
    public void execute() {
        log.info("You cast the spell of disintegration and the dragon vaporizes in a pile of dust!");
    }
}
