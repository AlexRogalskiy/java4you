package com.sensiblemetrics.api.alpenidos.core.state3.iface;

import com.sensiblemetrics.api.alpenidos.core.state3.impl.TrafficSignalState;

public interface TrafficSignalContext {

    void setTrafficSignalState(final TrafficSignalState state);
}
