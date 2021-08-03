package com.sensiblemetrics.api.alpenidos.pattern.singleton;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DoubleCheckedSingleton {
    private static DoubleCheckedSingleton instance;

    public static DoubleCheckedSingleton getInstance() {
        if (instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null)
                    instance = new DoubleCheckedSingleton();
            }
        }
        return instance;
    }
}
