package com.sensiblemetrics.api.alpenidos.pattern.cas;

class CasCounterAnswer {

    private final SimulatedCAS value = new SimulatedCAS();

    public int getValue() {
        return value.get();
    }

    public int increment() {
        int v;
        do {
            v = value.get();
        }
        while (!value.compareAndSet(v, v + 1));

        return v + 1;
    }
}
