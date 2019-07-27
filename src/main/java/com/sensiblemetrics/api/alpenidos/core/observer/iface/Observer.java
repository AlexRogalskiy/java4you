package com.sensiblemetrics.api.alpenidos.core.observer.iface;

import com.sensiblemetrics.api.alpenidos.core.observer.model.Event;

public interface Observer {

    void update(final Event event);
}
