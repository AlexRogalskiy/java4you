package com.sensiblemetrics.api.alpenidos.core.observer4.iface;

import com.sensiblemetrics.api.alpenidos.core.observer4.enums.TrafficSignalEvent;

public interface TrafficSignalObserver {

    void notify(final TrafficSignalEvent event);
}
