package com.sensiblemetrics.api.alpenidos.pattern.event.aggregator.impl;

import com.sensiblemetrics.api.alpenidos.pattern.event.aggregator.enums.Event;
import com.sensiblemetrics.api.alpenidos.pattern.event.aggregator.enums.Weekday;
import com.sensiblemetrics.api.alpenidos.pattern.event.aggregator.iface.EventObserver;

/**
 * Scout produces events.
 */
public class Scout extends EventEmitter {

    public Scout(final EventObserver obs) {
        super(obs);
    }

    @Override
    public void timePasses(final Weekday day) {
        if (day.equals(Weekday.TUESDAY)) {
            this.notifyObservers(Event.WARSHIPS_APPROACHING);
        }
    }
}
