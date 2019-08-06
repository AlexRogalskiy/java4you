package com.sensiblemetrics.api.alpenidos.core.extension_object.impl;

import com.sensiblemetrics.api.alpenidos.core.extension_object.iface.SoldierExtension;
import com.sensiblemetrics.api.alpenidos.core.extension_object.model.SoldierUnit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Class defining Soldier
 */
@Slf4j
@RequiredArgsConstructor
public class Soldier implements SoldierExtension {
    private final SoldierUnit unit;

    @Override
    public void soldierReady() {
        log.info("[Solider] " + this.unit.getName() + "  is ready!");
    }
}
