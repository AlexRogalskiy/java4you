package com.sensiblemetrics.api.alpenidos.pattern.singleton;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Double-checked locking design pattern applied to a singleton.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DclSingleton {
    /**
     * Current instance of the singleton.
     */
    private static volatile DclSingleton instance;

    /**
     * Returns the current instance of the singleton.
     *
     * @return the current instance of the singleton
     */
    public static DclSingleton getInstance() {
        if (instance == null) {
            synchronized (DclSingleton.class) {
                if (instance == null) {
                    instance = new DclSingleton();
                }
            }
        }
        return instance;
    }
}
