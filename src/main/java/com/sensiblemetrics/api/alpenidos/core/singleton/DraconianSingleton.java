package com.sensiblemetrics.api.alpenidos.core.singleton;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Draconian singleton. The method to get the instance is synchronized.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DraconianSingleton {

    /**
     * Current instance of the singleton.
     */
    private static DraconianSingleton instance;

    /**
     * Returns the current instance of the singleton.
     *
     * @return the current instance of the singleton
     */
    public static synchronized DraconianSingleton getInstance() {
        if (instance == null) {
            instance = new DraconianSingleton();
        }
        return instance;
    }
}
