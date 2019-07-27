package com.sensiblemetrics.api.alpenidos.core.observer.impl;

import com.sensiblemetrics.api.alpenidos.core.observer.iface.Observer;
import com.sensiblemetrics.api.alpenidos.core.observer.model.Event;
import com.sensiblemetrics.api.alpenidos.core.observer.model.Subject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class ConcreteSubject extends Subject {

    private final HashMap<Integer, LinkedList<Observer>> observers;

    public ConcreteSubject() {
        this.observers = new HashMap();
    }

    private LinkedList<Observer> getList(int type) {
        if (!observers.containsKey(type)) {
            this.observers.put(type, new LinkedList());
        }
        return this.observers.get(type);
    }

    @Override
    public void attach(final int eventType, final Observer newObserver) {
        getList(eventType).add(newObserver);
    }

    @Override
    public void detach(int eventType, Observer observer) {
        getList(eventType).remove(observer);
    }

    @Override
    public void notifyObserver(final int eventType, final Event event) {
        if (this.observers.containsKey(eventType)) {
            Iterator<Observer> iterator = this.observers.get(eventType).iterator();
            while (iterator.hasNext()) {
                iterator.next().update(event);
            }
        }
    }
}
