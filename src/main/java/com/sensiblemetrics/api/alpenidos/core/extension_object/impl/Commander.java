package com.sensiblemetrics.api.alpenidos.core.extension_object.impl;

import com.sensiblemetrics.api.alpenidos.core.extension_object.iface.CommanderExtension;
import com.sensiblemetrics.api.alpenidos.core.extension_object.model.CommanderUnit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Class defining Commander
 */
@Slf4j
@RequiredArgsConstructor
public class Commander implements CommanderExtension {
    private final CommanderUnit unit;

    @Override
    public void commanderReady() {
        log.info("[Commander] " + unit.getName() + " is ready!");
    }
}
