package com.sensiblemetrics.api.alpenidos.core.extension_object.model;

import com.sensiblemetrics.api.alpenidos.core.extension_object.iface.UnitExtension;
import com.sensiblemetrics.api.alpenidos.core.extension_object.impl.Sergeant;

/**
 * Class defining SergeantUnit
 */
public class SergeantUnit extends Unit {

    public SergeantUnit(String name) {
        super(name);
    }

    @Override
    public UnitExtension getUnitExtension(final String extensionName) {
        if (extensionName.equals("SergeantExtension")) {
            if (this.unitExtension == null) {
                this.unitExtension = new Sergeant(this);
            }
            return this.unitExtension;
        }
        return super.getUnitExtension(extensionName);
    }
}
