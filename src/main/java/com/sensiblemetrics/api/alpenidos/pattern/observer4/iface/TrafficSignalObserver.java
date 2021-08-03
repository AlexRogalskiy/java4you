package com.sensiblemetrics.api.alpenidos.pattern.observer4.iface;

import com.sensiblemetrics.api.alpenidos.pattern.observer4.enums.TrafficSignalEvent;

public interface TrafficSignalObserver {

    void notify(final TrafficSignalEvent event);
}
