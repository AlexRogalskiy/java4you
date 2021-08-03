package com.sensiblemetrics.api.alpenidos.pattern.extension_object.model;

import com.sensiblemetrics.api.alpenidos.pattern.extension_object.iface.UnitExtension;
import lombok.Data;

/**
 * Class defining Unit, other units will extend this class
 */
@Data
public class Unit {
    private String name;
    protected UnitExtension unitExtension = null;

    public Unit(final String name) {
        this.name = name;
    }

    public UnitExtension getUnitExtension(String extensionName) {
        return null;
    }
}
