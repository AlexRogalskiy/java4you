package com.sensiblemetrics.api.alpenidos.core.event.aggregator.impl;

import com.sensiblemetrics.api.alpenidos.core.event.aggregator.enums.Event;
import com.sensiblemetrics.api.alpenidos.core.event.aggregator.enums.Weekday;
import com.sensiblemetrics.api.alpenidos.core.event.aggregator.iface.EventObserver;

/**
 * LordVarys produces events.
 */
public class LordVarys extends EventEmitter {

    public LordVarys(final EventObserver obs) {
        super(obs);
    }

    @Override
    public void timePasses(final Weekday day) {
        if (day.equals(Weekday.SATURDAY)) {
            this.notifyObservers(Event.TRAITOR_DETECTED);
        }
    }
}
