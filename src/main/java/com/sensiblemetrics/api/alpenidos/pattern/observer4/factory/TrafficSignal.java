package com.sensiblemetrics.api.alpenidos.pattern.observer4.factory;

import com.sensiblemetrics.api.alpenidos.pattern.observer4.enums.TrafficSignalEvent;
import com.sensiblemetrics.api.alpenidos.pattern.observer4.iface.TrafficSignalButtonObserver;
import com.sensiblemetrics.api.alpenidos.pattern.observer4.iface.TrafficSignalContext;
import com.sensiblemetrics.api.alpenidos.pattern.observer4.iface.TrafficSignalObserver;
import com.sensiblemetrics.api.alpenidos.pattern.observer4.impl.TrafficSignalGreenState;
import com.sensiblemetrics.api.alpenidos.pattern.observer4.impl.TrafficSignalState;

import java.util.HashSet;
import java.util.Set;

public class TrafficSignal extends Thread implements TrafficSignalContext, TrafficSignalButtonObserver {
    private TrafficSignalState state;
    private Set<TrafficSignalObserver> observers;

    public TrafficSignal() {
        this.observers = new HashSet<>();
    }

    public void register(final TrafficSignalObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void setTrafficSignalState(final TrafficSignalState state) {
        this.state = state;
        switch (state.getName()) {
            case GREEN:
                this.notify(TrafficSignalEvent.TURNED_GREEN);
                break;
            case ORANGE:
                this.notify(TrafficSignalEvent.TURNED_ORANGE);
                break;
            case RED:
                this.notify(TrafficSignalEvent.TURNED_RED);
                break;
        }
    }

    private void notify(final TrafficSignalEvent event) {
        this.observers.forEach(o -> o.notify(event));
    }

    @Override
    public void notifyButtonPressed() {
        this.notify(TrafficSignalEvent.BUTTON_PRESSED);
        this.state.buttonPressed();
    }

    public void run() {
        this.setTrafficSignalState(new TrafficSignalGreenState(this));
        while (true) {
            try {
                Thread.sleep(1000);
                this.state.secondEllapsed();
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
