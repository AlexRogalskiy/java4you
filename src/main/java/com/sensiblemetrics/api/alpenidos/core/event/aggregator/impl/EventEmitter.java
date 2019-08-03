package com.sensiblemetrics.api.alpenidos.core.event.aggregator.impl;

import com.sensiblemetrics.api.alpenidos.core.event.aggregator.enums.Event;
import com.sensiblemetrics.api.alpenidos.core.event.aggregator.enums.Weekday;
import com.sensiblemetrics.api.alpenidos.core.event.aggregator.iface.EventObserver;

import java.util.LinkedList;
import java.util.List;

/**
 * EventEmitter is the base class for event producers that can be observed.
 */
public abstract class EventEmitter {

    private List<EventObserver> observers;

    public EventEmitter() {
        this.observers = new LinkedList<>();
    }

    public EventEmitter(final EventObserver obs) {
        this();
        this.registerObserver(obs);
    }

    public final void registerObserver(final EventObserver obs) {
        this.observers.add(obs);
    }

    protected void notifyObservers(final Event e) {
        this.observers.forEach(o -> o.onEvent(e));
    }

    public abstract void timePasses(final Weekday day);
}
