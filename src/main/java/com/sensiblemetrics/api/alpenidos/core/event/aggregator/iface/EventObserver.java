package com.sensiblemetrics.api.alpenidos.core.event.aggregator.iface;

import com.sensiblemetrics.api.alpenidos.core.event.aggregator.enums.Event;

/**
 * Observers of events implement this interface.
 */
public interface EventObserver {

    void onEvent(final Event e);
}
