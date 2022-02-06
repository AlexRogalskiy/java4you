package com.sensiblemetrics.api.alpenidos.pattern.vehicle.enumeration;

import com.sensiblemetrics.api.alpenidos.pattern.vehicle.model.Bus;
import com.sensiblemetrics.api.alpenidos.pattern.vehicle.model.Car;
import com.sensiblemetrics.api.alpenidos.pattern.vehicle.model.Truck;
import com.sensiblemetrics.api.alpenidos.pattern.vehicle.model.Vehicle;

import java.util.function.Function;

public enum VehicleType {
    BUS(Bus::new),
    TRUCK(Truck::new),
    CAR(Car::new);

    public final Function<VehicleColor, Vehicle> factory;

    VehicleType(final Function<VehicleColor, Vehicle> factory) {
        this.factory = factory;
    }
}
