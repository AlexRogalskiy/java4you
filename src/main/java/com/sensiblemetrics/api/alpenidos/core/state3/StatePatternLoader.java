package com.sensiblemetrics.api.alpenidos.core.state3;

import com.sensiblemetrics.api.alpenidos.core.state3.model.TrafficSignal;

import java.util.Random;

public class StatePatternLoader {

    public static void main(final String[] args) {
        final Random rng = new Random();
        final TrafficSignal trafficSignal = new TrafficSignal();
        trafficSignal.start();

        while (true) {
            int delay = rng.nextInt(10);
            try {
                Thread.sleep(delay * 1000);
            } catch (InterruptedException e) {
            }
            trafficSignal.pressButton();
        }
    }
}
