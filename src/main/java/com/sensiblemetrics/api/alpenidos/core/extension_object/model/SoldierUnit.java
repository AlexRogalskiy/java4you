package com.sensiblemetrics.api.alpenidos.core.extension_object.model;

import com.sensiblemetrics.api.alpenidos.core.extension_object.iface.UnitExtension;
import com.sensiblemetrics.api.alpenidos.core.extension_object.impl.Soldier;

/**
 * Class defining SoldierUnit
 */
public class SoldierUnit extends Unit {

    public SoldierUnit(final String name) {
        super(name);
    }

    @Override
    public UnitExtension getUnitExtension(final String extensionName) {
        if (extensionName.equals("SoldierExtension")) {
            if (this.unitExtension == null) {
                this.unitExtension = new Soldier(this);
            }
            return this.unitExtension;
        }
        return super.getUnitExtension(extensionName);
    }
}
