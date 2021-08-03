package com.sensiblemetrics.api.alpenidos.pattern.flyweight2.impl;

import com.sensiblemetrics.api.alpenidos.pattern.flyweight2.iface.Potion;
import lombok.extern.slf4j.Slf4j;

/**
 * HolyWaterPotion
 */
@Slf4j
public class HolyWaterPotion implements Potion {

    @Override
    public void drink() {
        log.info("You feel blessed. (Potion={})", System.identityHashCode(this));
    }
}
