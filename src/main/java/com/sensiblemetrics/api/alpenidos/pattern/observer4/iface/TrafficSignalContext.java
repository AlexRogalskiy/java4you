package com.sensiblemetrics.api.alpenidos.pattern.observer4.iface;

import com.sensiblemetrics.api.alpenidos.pattern.observer4.impl.TrafficSignalState;

public interface TrafficSignalContext {

    void setTrafficSignalState(final TrafficSignalState state);
}
