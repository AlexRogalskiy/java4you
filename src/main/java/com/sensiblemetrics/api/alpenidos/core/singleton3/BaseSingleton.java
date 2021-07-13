package com.sensiblemetrics.api.alpenidos.core.singleton3;

public class BaseSingleton {

    protected static BaseSingleton uniqueInstance;

    // other useful instance variables here

    protected BaseSingleton() {
    }

    public static synchronized BaseSingleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new BaseSingleton();
        }
        return uniqueInstance;
    }

    // other useful methods here
}
