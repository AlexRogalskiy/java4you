package com.sensiblemetrics.api.alpenidos.core.flyweight2.impl;

import com.sensiblemetrics.api.alpenidos.core.flyweight2.iface.Potion;
import lombok.extern.slf4j.Slf4j;

/**
 * HealingPotion
 */
@Slf4j
public class HealingPotion implements Potion {

    @Override
    public void drink() {
        log.info("You feel healed. (Potion={})", System.identityHashCode(this));
    }
}
