package com.sensiblemetrics.api.alpenidos.pattern.vehicle.model;

public abstract class AbstractVehicle implements Vehicle {

    public void start() {
        this.preStartCheck();
        System.out.printf("%s starting...%n", this.getClass().getSimpleName());
    }

    protected abstract void preStartCheck();
}
