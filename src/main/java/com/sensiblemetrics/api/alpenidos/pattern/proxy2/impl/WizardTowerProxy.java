package com.sensiblemetrics.api.alpenidos.pattern.proxy2.impl;

import com.sensiblemetrics.api.alpenidos.pattern.proxy2.model.Wizard;
import com.sensiblemetrics.api.alpenidos.pattern.proxy2.iface.WizardTower;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * The proxy controlling access to the {@link IvoryTower}.
 */
@Slf4j
@RequiredArgsConstructor
public class WizardTowerProxy implements WizardTower {
    private static final int NUM_WIZARDS_ALLOWED = 3;
    private final WizardTower tower;
    private int numWizards;

    @Override
    public void enter(final Wizard wizard) {
        if (this.numWizards < NUM_WIZARDS_ALLOWED) {
            this.tower.enter(wizard);
            this.numWizards++;
        } else {
            log.info("{} is not allowed to enter!", wizard);
        }
    }
}
