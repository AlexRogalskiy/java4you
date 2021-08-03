package com.sensiblemetrics.api.alpenidos.pattern.lazy_init;

import com.sensiblemetrics.api.alpenidos.pattern.lazy_init.enums.VehicleType;

public class LazyInitializationPattern {

    public static void main(final String[] args) {
        Vehicle.getVehicleByTypeName(VehicleType.car);
        Vehicle.showAll();
        Vehicle.getVehicleByTypeName(VehicleType.bus);
        Vehicle.showAll();
        Vehicle.getVehicleByTypeName(VehicleType.car);
        Vehicle.showAll();
    }
}
