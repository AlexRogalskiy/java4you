package com.sensiblemetrics.api.alpenidos.pattern.carwash.steps;

import com.sensiblemetrics.api.alpenidos.pattern.carwash.model.Car;

public abstract class CarWashStep {
    protected CarWashStep nextStep;

    public CarWashStep andThen(final CarWashStep nextStep) {
        this.nextStep = nextStep;
        return nextStep;
    }

    public abstract Car applyTo(final Car car);
}
