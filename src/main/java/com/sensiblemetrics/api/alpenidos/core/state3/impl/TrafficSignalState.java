package com.sensiblemetrics.api.alpenidos.core.state3.impl;

import com.sensiblemetrics.api.alpenidos.core.state3.enums.TrafficSignalStateName;
import com.sensiblemetrics.api.alpenidos.core.state3.iface.TrafficSignalContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class TrafficSignalState {
    protected final TrafficSignalContext context;
    protected int durationInSeconds;
    private final TrafficSignalStateName name;

    public TrafficSignalState(final TrafficSignalContext context, final int durationInSeconds, final TrafficSignalStateName name) {
        this.context = context;
        this.durationInSeconds = durationInSeconds;
        this.name = name;
    }

    public void buttonPressed() {
        log.info("button pressed!");
    }

    public void secondEllapsed() {
        this.durationInSeconds--;
        log.info("Duration: " + this.durationInSeconds);
    }

    public TrafficSignalStateName getName() {
        return this.name;
    }
}
