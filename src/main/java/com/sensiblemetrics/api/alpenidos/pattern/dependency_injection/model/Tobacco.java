package com.sensiblemetrics.api.alpenidos.pattern.dependency_injection.model;

import com.sensiblemetrics.api.alpenidos.pattern.dependency_injection.iface.Wizard;
import lombok.extern.slf4j.Slf4j;

/**
 * Tobacco abstraction
 */
@Slf4j
public abstract class Tobacco {

    public void smoke(final Wizard wizard) {
        log.info("{} smoking {}", wizard.getClass().getSimpleName(), this.getClass().getSimpleName());
    }
}
