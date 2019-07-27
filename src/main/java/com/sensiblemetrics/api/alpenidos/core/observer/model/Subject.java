package com.sensiblemetrics.api.alpenidos.core.observer.model;

import com.sensiblemetrics.api.alpenidos.core.observer.iface.Observer;
import com.sensiblemetrics.api.alpenidos.core.observer.model.Event;

public abstract class Subject {

    public abstract void attach(int eventType, final Observer observer);

    public abstract void detach(int eventType, final Observer observer);

    public abstract void notifyObserver(int eventType, final Event event);
}
