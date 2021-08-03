package com.sensiblemetrics.api.alpenidos.pattern.mediator3.impl;

import com.sensiblemetrics.api.alpenidos.pattern.mediator3.iface.Mediator;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Colleague defines an interface for communication with another Colleague via
 * mediator.
 */
@Data
@RequiredArgsConstructor
public abstract class Colleague {
    protected final Mediator mediator;

    private String receivedMessage;

    abstract void notifyColleague(final String message);

    abstract void receive(final String message);
}
