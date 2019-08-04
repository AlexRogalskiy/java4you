package com.sensiblemetrics.api.alpenidos.core.extension_object.impl;

import com.sensiblemetrics.api.alpenidos.core.extension_object.iface.SergeantExtension;
import com.sensiblemetrics.api.alpenidos.core.extension_object.model.SergeantUnit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Class defining Sergeant
 */
@Slf4j
@RequiredArgsConstructor
public class Sergeant implements SergeantExtension {
    private final SergeantUnit unit;

    @Override
    public void sergeantReady() {
        log.info("[Sergeant] " + unit.getName() + " is ready! ");
    }
}
