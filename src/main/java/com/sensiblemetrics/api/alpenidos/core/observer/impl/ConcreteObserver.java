package com.sensiblemetrics.api.alpenidos.core.observer.impl;

import com.sensiblemetrics.api.alpenidos.core.observer.iface.Observer;
import com.sensiblemetrics.api.alpenidos.core.observer.model.Event;

public class ConcreteObserver implements Observer {

    private static int ID = 0;

    @Override
    public void update(Event event) {
        System.out.println(
            "ID: " + (++ID) +
                ", Updating event type: " + event.getType() +
                ", Event description: " + event.getDescription());
    }
}
