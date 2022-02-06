package com.sensiblemetrics.api.alpenidos.pattern.vehicle.model;

import com.sensiblemetrics.api.alpenidos.pattern.vehicle.enumeration.VehicleColor;

public class Truck implements Vehicle {
    private final VehicleColor color;

    public Truck(final VehicleColor color) {
        this.color = color;
    }

    public VehicleColor color() {
        return color;
    }
}
