package com.sensiblemetrics.api.alpenidos.core.strategy3.impl;

import com.sensiblemetrics.api.alpenidos.core.strategy3.iface.DragonSlayingStrategy;
import lombok.extern.slf4j.Slf4j;

/**
 * Projectile strategy.
 */
@Slf4j
public class ProjectileStrategy implements DragonSlayingStrategy {

    @Override
    public void execute() {
        log.info("You shoot the dragon with the magical crossbow and it falls dead on the ground!");
    }
}
