package com.sensiblemetrics.api.alpenidos.pattern.observer4;

import com.sensiblemetrics.api.alpenidos.pattern.observer4.factory.TrafficSignal;
import com.sensiblemetrics.api.alpenidos.pattern.observer4.factory.TrafficSignalButtonPresser;
import com.sensiblemetrics.api.alpenidos.pattern.observer4.factory.TrafficSignalConsoleDisplay;
import com.sensiblemetrics.api.alpenidos.pattern.observer4.iface.TrafficSignalObserver;

public class ObserverPatternLoader {

    public static void main(final String[] args) {
        final TrafficSignal trafficSignal = new TrafficSignal();
        final TrafficSignalObserver display = new TrafficSignalConsoleDisplay();
        final TrafficSignalButtonPresser buttonPresser = new TrafficSignalButtonPresser();

        trafficSignal.register(display);
        buttonPresser.register(trafficSignal);

        trafficSignal.start();
        buttonPresser.start();
    }
}
