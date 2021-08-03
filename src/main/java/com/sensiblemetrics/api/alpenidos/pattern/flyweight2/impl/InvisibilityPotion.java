package com.sensiblemetrics.api.alpenidos.pattern.flyweight2.impl;

import com.sensiblemetrics.api.alpenidos.pattern.flyweight2.iface.Potion;
import lombok.extern.slf4j.Slf4j;

/**
 * InvisibilityPotion
 */
@Slf4j
public class InvisibilityPotion implements Potion {

    @Override
    public void drink() {
        log.info("You become invisible. (Potion={})", System.identityHashCode(this));
    }
}
