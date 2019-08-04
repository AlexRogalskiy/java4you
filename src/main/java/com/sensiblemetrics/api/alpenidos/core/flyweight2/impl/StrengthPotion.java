package com.sensiblemetrics.api.alpenidos.core.flyweight2.impl;

import com.sensiblemetrics.api.alpenidos.core.flyweight2.iface.Potion;
import lombok.extern.slf4j.Slf4j;

/**
 * StrengthPotion
 */
@Slf4j
public class StrengthPotion implements Potion {

    @Override
    public void drink() {
        log.info("You feel strong. (Potion={})", System.identityHashCode(this));
    }
}
