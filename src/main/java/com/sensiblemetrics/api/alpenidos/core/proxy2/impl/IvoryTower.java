package com.sensiblemetrics.api.alpenidos.core.proxy2.impl;

import com.sensiblemetrics.api.alpenidos.core.proxy2.model.Wizard;
import com.sensiblemetrics.api.alpenidos.core.proxy2.iface.WizardTower;
import lombok.extern.slf4j.Slf4j;

/**
 * The object to be proxyed.
 */
@Slf4j
public class IvoryTower implements WizardTower {

    public void enter(Wizard wizard) {
        log.info("{} enters the tower.", wizard);
    }
}
