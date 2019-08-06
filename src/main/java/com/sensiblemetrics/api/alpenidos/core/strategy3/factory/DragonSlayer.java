package com.sensiblemetrics.api.alpenidos.core.strategy3.factory;

import com.sensiblemetrics.api.alpenidos.core.strategy3.iface.DragonSlayingStrategy;

/**
 * DragonSlayer uses different strategies to slay the dragon.
 */
public class DragonSlayer {
    private DragonSlayingStrategy strategy;

    public DragonSlayer(final DragonSlayingStrategy strategy) {
        this.strategy = strategy;
    }

    public void changeStrategy(final DragonSlayingStrategy strategy) {
        this.strategy = strategy;
    }

    public void goToBattle() {
        this.strategy.execute();
    }
}
