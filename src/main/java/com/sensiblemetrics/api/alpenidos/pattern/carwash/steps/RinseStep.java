package com.sensiblemetrics.api.alpenidos.pattern.carwash.steps;

import com.sensiblemetrics.api.alpenidos.pattern.carwash.enumeration.WashState;
import com.sensiblemetrics.api.alpenidos.pattern.carwash.model.Car;

public class RinseStep extends CarWashStep {
    @Override
    public Car applyTo(final Car car) {
        final Car newCar = car.updateState(WashState.RINSED);
        if (this.nextStep != null) {
            return this.nextStep.applyTo(newCar);
        }

        return newCar;
    }
}
