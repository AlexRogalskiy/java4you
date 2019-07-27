package com.sensiblemetrics.api.alpenidos.core.singleton;

/**
 * Draconian singleton. The method to get the instance is synchronized.
 */
public class DraconianSingleton {

    /**
     * Current instance of the singleton.
     */
    private static DraconianSingleton instance;

    /**
     * Private constructor to avoid instantiation.
     */
    private DraconianSingleton() {
    }

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
