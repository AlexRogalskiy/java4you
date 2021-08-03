package com.sensiblemetrics.api.alpenidos.pattern.observer.iface;

import com.sensiblemetrics.api.alpenidos.pattern.observer.model.Event;

public interface Observer {

    void update(final Event event);
}
