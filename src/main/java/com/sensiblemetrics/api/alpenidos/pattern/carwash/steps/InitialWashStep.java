package com.sensiblemetrics.api.alpenidos.pattern.carwash.steps;

import com.sensiblemetrics.api.alpenidos.pattern.carwash.enumeration.WashState;
import com.sensiblemetrics.api.alpenidos.pattern.carwash.model.Car;

public class InitialWashStep extends CarWashStep {

    @Override
    public Car applyTo(final Car car) {
        final Car newCar = car.updateState(WashState.INITIAL_WASH);
        if (this.nextStep != null) {
            return this.nextStep.applyTo(newCar);
        }

        return newCar;
    }
}
