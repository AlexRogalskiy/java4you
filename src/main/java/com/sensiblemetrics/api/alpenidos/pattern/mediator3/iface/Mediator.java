package com.sensiblemetrics.api.alpenidos.pattern.mediator3.iface;

import com.sensiblemetrics.api.alpenidos.pattern.mediator3.impl.Colleague;

/**
 * Mediator defines an interface for communicating with Colleague objects.
 */
public interface Mediator {

    void notifyColleague(final Colleague colleague, final String message);
}
