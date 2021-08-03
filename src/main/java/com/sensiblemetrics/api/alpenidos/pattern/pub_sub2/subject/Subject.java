package com.sensiblemetrics.api.alpenidos.pattern.pub_sub2.subject;

import com.sensiblemetrics.api.alpenidos.pattern.pub_sub2.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private final List<Observer> observers = new ArrayList<Observer>();

    public void attach(final Observer observer) {
        this.observers.add(observer);
    }

    public void detach(final Observer observer) {
        this.observers.remove(observer);
    }

    public void notifyA() {
        this.observers.forEach(Observer::update);
    }
}
