package com.sensiblemetrics.api.alpenidos.pattern.event.aggregator.impl;

import com.sensiblemetrics.api.alpenidos.pattern.event.aggregator.enums.Event;
import com.sensiblemetrics.api.alpenidos.pattern.event.aggregator.enums.Weekday;
import com.sensiblemetrics.api.alpenidos.pattern.event.aggregator.iface.EventObserver;

/**
 * KingsHand observes events from multiple sources and delivers them to listeners.
 */
public class KingsHand extends EventEmitter implements EventObserver {

    public KingsHand(final EventObserver obs) {
        super(obs);
    }

    @Override
    public void onEvent(final Event e) {
        this.notifyObservers(e);
    }

    @Override
    public void timePasses(Weekday day) {
        // NOP
    }
}
