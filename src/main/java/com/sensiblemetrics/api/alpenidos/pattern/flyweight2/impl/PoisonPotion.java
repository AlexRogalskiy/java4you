package com.sensiblemetrics.api.alpenidos.pattern.flyweight2.impl;

import com.sensiblemetrics.api.alpenidos.pattern.flyweight2.iface.Potion;
import lombok.extern.slf4j.Slf4j;

/**
 * PoisonPotion
 */
@Slf4j
public class PoisonPotion implements Potion {

    @Override
    public void drink() {
        log.info("Urgh! This is poisonous. (Potion={})", System.identityHashCode(this));
    }
}
