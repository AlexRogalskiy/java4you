package com.sensiblemetrics.api.alpenidos.pattern.vehicle.model;

import com.sensiblemetrics.api.alpenidos.pattern.vehicle.enumeration.VehicleColor;

public class Car implements Vehicle {
    private final VehicleColor color;

    public Car(final VehicleColor color) {
        this.color = color;
    }

    public VehicleColor color() {
        return color;
    }
}
