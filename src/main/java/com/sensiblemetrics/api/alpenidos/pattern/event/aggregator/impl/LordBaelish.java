package com.sensiblemetrics.api.alpenidos.pattern.event.aggregator.impl;

import com.sensiblemetrics.api.alpenidos.pattern.event.aggregator.enums.Event;
import com.sensiblemetrics.api.alpenidos.pattern.event.aggregator.enums.Weekday;
import com.sensiblemetrics.api.alpenidos.pattern.event.aggregator.iface.EventObserver;

/**
 * LordBaelish produces events.
 */
public class LordBaelish extends EventEmitter {

    public LordBaelish(final EventObserver obs) {
        super(obs);
    }

    @Override
    public void timePasses(final Weekday day) {
        if (day.equals(Weekday.FRIDAY)) {
            this.notifyObservers(Event.STARK_SIGHTED);
        }
    }
}
