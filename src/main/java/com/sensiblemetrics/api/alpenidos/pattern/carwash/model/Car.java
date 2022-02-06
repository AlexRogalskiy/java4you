package com.sensiblemetrics.api.alpenidos.pattern.carwash.model;

import com.sensiblemetrics.api.alpenidos.pattern.carwash.enumeration.WashState;

public class Car {
    private WashState washState;

    public Car() {
        this.washState = WashState.INITIAL;
        System.out.println("Car state transitioned to " + this.washState);
    }

    public Car updateState(final WashState state) {
        System.out.println("Car state transitioned to " + state);
        this.washState = state;
        return this;
    }

    public WashState washState() {
        return this.washState;
    }
}
