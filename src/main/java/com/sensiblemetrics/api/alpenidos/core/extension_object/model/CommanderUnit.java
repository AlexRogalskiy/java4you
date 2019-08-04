package com.sensiblemetrics.api.alpenidos.core.extension_object.model;

import com.sensiblemetrics.api.alpenidos.core.extension_object.iface.UnitExtension;
import com.sensiblemetrics.api.alpenidos.core.extension_object.impl.Commander;

/**
 * Class defining CommanderUnit
 */
public class CommanderUnit extends Unit {

    public CommanderUnit(final String name) {
        super(name);
    }

    @Override
    public UnitExtension getUnitExtension(final String extensionName) {
        if (extensionName.equals("CommanderExtension")) {
            if (this.unitExtension == null) {
                this.unitExtension = new Commander(this);
            }
            return unitExtension;
        }
        return super.getUnitExtension(extensionName);
    }
}
