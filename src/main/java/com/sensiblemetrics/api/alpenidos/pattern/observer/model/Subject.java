package com.sensiblemetrics.api.alpenidos.pattern.observer.model;

import com.sensiblemetrics.api.alpenidos.pattern.observer.iface.Observer;

public abstract class Subject {

    public abstract void attach(int eventType, final Observer observer);

    public abstract void detach(int eventType, final Observer observer);

    public abstract void notifyObserver(int eventType, final Event event);
}
