package com.sensiblemetrics.api.alpenidos.core.mediator3.impl;

import com.sensiblemetrics.api.alpenidos.core.mediator3.iface.Mediator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ConcreteMediator implements Mediator, coordinates between Colleague objects.
 */
public class ConcreteMediator implements Mediator {
    private final List<Colleague> colleagues;

    public ConcreteMediator() {
        this.colleagues = new ArrayList<>();
    }

    public void addColleague(final Colleague colleague) {
        this.colleagues.add(colleague);
    }

    public void notifyColleague(final Colleague colleague, final String message) {
        for (final Iterator iterator = this.colleagues.iterator(); iterator.hasNext(); ) {
            final Colleague receiverColleague = (Colleague) iterator.next();
            if (colleague != receiverColleague) {
                receiverColleague.receive(message);
            }
        }
    }
}
