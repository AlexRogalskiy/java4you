package com.sensiblemetrics.api.alpenidos.pattern.state3.impl;

import com.sensiblemetrics.api.alpenidos.pattern.state3.enums.TrafficSignalStateName;
import com.sensiblemetrics.api.alpenidos.pattern.state3.iface.TrafficSignalContext;

public class TrafficSignalGreenState extends TrafficSignalState {
    private final static int GREEN_STATE_DURATION_IN_SECONDS = 10;
    private final static int BUTTON_DURATION_IN_SECONDS = 2;

    public TrafficSignalGreenState(final TrafficSignalContext context) {
        super(context, GREEN_STATE_DURATION_IN_SECONDS, TrafficSignalStateName.GREEN);
    }

    @Override
    public void buttonPressed() {
        super.buttonPressed();
        if (this.durationInSeconds > BUTTON_DURATION_IN_SECONDS)
            this.durationInSeconds = BUTTON_DURATION_IN_SECONDS;
    }

    @Override
    public void secondEllapsed() {
        super.secondEllapsed();
        if (this.durationInSeconds == 0)
            this.context.setTrafficSignalState(new TrafficSignalOrangeState(this.context));
    }
}
