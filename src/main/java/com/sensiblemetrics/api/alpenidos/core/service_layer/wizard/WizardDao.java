package com.sensiblemetrics.api.alpenidos.core.service_layer.wizard;

import com.sensiblemetrics.api.alpenidos.core.service_layer.common.Dao;

/**
 * WizardDao interface.
 */
public interface WizardDao extends Dao<Wizard> {

    Wizard findByName(final String name);
}
