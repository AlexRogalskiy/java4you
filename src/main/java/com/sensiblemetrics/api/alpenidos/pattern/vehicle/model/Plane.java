package com.sensiblemetrics.api.alpenidos.pattern.vehicle.model;

public class Plane extends AbstractVehicle {
    @Override
    protected void preStartCheck() {
        System.out.println("Checking that doors are properly closed!");
    }
}
