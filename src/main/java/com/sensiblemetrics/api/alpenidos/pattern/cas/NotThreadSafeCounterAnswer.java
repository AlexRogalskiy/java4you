package com.sensiblemetrics.api.alpenidos.pattern.cas;

class NotThreadSafeCounterAnswer {

    private int value = 0;

    int getValue() {
        return value;
    }

    int increment() {
        return ++value;
    }
}
