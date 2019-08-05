package service_layer.wizard;

import service_layer.common.Dao;

/**
 * WizardDao interface.
 */
public interface WizardDao extends Dao<Wizard> {

    Wizard findByName(final String name);
}
