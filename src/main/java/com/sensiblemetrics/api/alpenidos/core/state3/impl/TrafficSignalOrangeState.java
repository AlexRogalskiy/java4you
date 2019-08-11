package com.sensiblemetrics.api.alpenidos.core.state3.impl;

import com.sensiblemetrics.api.alpenidos.core.state3.enums.TrafficSignalStateName;
import com.sensiblemetrics.api.alpenidos.core.state3.iface.TrafficSignalContext;

public class TrafficSignalOrangeState extends TrafficSignalState {
    private final static int ORANGE_STATE_DURATION_IN_SECONDS = 2;

    public TrafficSignalOrangeState(final TrafficSignalContext context) {
        super(context, ORANGE_STATE_DURATION_IN_SECONDS, TrafficSignalStateName.ORANGE);
    }

    @Override
    public void secondEllapsed() {
        super.secondEllapsed();
        if (this.durationInSeconds == 0)
            this.context.setTrafficSignalState(new TrafficSignalRedState(this.context));
    }
}
