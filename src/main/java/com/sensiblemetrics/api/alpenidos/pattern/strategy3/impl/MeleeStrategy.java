package com.sensiblemetrics.api.alpenidos.pattern.strategy3.impl;

import com.sensiblemetrics.api.alpenidos.pattern.strategy3.iface.DragonSlayingStrategy;
import lombok.extern.slf4j.Slf4j;

/**
 * Melee strategy.
 */
@Slf4j
public class MeleeStrategy implements DragonSlayingStrategy {

    @Override
    public void execute() {
        log.info("With your Excalibur you sever the dragon's head!");
    }
}
