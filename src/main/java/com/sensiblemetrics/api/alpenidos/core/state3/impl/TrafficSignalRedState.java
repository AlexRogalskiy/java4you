package com.sensiblemetrics.api.alpenidos.core.state3.impl;

import com.sensiblemetrics.api.alpenidos.core.state3.enums.TrafficSignalStateName;
import com.sensiblemetrics.api.alpenidos.core.state3.iface.TrafficSignalContext;

public class TrafficSignalRedState extends TrafficSignalState {
    private final static int RED_STATE_DURATION_IN_SECONDS = 10;

    public TrafficSignalRedState(final TrafficSignalContext context) {
        super(context, RED_STATE_DURATION_IN_SECONDS, TrafficSignalStateName.RED);
    }

    @Override
    public void secondEllapsed() {
        super.secondEllapsed();
        if (this.durationInSeconds == 0)
            this.context.setTrafficSignalState(new TrafficSignalGreenState(this.context));
    }
}
