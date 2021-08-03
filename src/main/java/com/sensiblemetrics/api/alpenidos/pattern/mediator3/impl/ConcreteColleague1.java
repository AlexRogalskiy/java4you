package com.sensiblemetrics.api.alpenidos.pattern.mediator3.impl;

import com.sensiblemetrics.api.alpenidos.pattern.mediator3.iface.Mediator;

/**
 * ConcreteColleague1 implements Colleague interface.
 */
public class ConcreteColleague1 extends Colleague {

    public ConcreteColleague1(final Mediator mediator) {
        super(mediator);
    }

    public void notifyColleague(final String message) {
        this.mediator.notifyColleague(this, message);
    }

    public void receive(final String message) {
        this.setReceivedMessage(message);
    }
}
