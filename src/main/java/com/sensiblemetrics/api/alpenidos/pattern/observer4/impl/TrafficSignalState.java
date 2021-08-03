package com.sensiblemetrics.api.alpenidos.pattern.observer4.impl;

import com.sensiblemetrics.api.alpenidos.pattern.observer4.enums.TrafficSignalStateName;
import com.sensiblemetrics.api.alpenidos.pattern.observer4.iface.TrafficSignalContext;

public abstract class TrafficSignalState {
    protected final TrafficSignalContext context;
    protected int durationInSeconds;
    private final TrafficSignalStateName name;

    public TrafficSignalState(TrafficSignalContext context, int durationInSeconds, TrafficSignalStateName name) {
        super();
        this.context = context;
        this.durationInSeconds = durationInSeconds;
        this.name = name;
    }

    public void buttonPressed() {
    }

    public void secondEllapsed() {
        this.durationInSeconds--;
    }

    public TrafficSignalStateName getName() {
        return this.name;
    }
}
