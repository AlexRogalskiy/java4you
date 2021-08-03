package com.sensiblemetrics.api.alpenidos.pattern.decorator2.impl;

import com.sensiblemetrics.api.alpenidos.pattern.decorator2.iface.Troll;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Decorator that adds a club for the troll
 */
@Slf4j
@RequiredArgsConstructor
public class ClubbedTroll implements Troll {
    private final Troll decorated;

    @Override
    public void attack() {
        this.decorated.attack();
        log.info("The troll swings at you with a club!");
    }

    @Override
    public int getAttackPower() {
        return this.decorated.getAttackPower() + 10;
    }

    @Override
    public void fleeBattle() {
        this.decorated.fleeBattle();
    }
}
