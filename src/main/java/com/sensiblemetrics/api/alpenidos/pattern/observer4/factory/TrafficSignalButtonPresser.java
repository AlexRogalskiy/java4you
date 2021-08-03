package com.sensiblemetrics.api.alpenidos.pattern.observer4.factory;

import com.sensiblemetrics.api.alpenidos.pattern.observer4.iface.TrafficSignalButtonObserver;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class TrafficSignalButtonPresser extends Thread {
    private final Set<TrafficSignalButtonObserver> observers;

    public TrafficSignalButtonPresser() {
        this.observers = new HashSet<>();
    }

    public void register(final TrafficSignalButtonObserver observer) {
        this.observers.add(observer);
    }

    public void run() {
        final Random rng = new Random();
        while (true) {
            int delay = rng.nextInt(10);
            try {
                Thread.sleep(delay * 1000);
            } catch (InterruptedException e) {
            }
            this.notifyButtonPressed();
        }
    }

    private void notifyButtonPressed() {
        this.observers.forEach(o -> o.notifyButtonPressed());
    }
}
