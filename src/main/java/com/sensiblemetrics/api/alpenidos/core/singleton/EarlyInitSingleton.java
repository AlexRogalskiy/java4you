package com.sensiblemetrics.api.alpenidos.core.singleton;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Singleton with early initialization. Inlines the singleton instance
 * initialization.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class EarlyInitSingleton {

    /**
     * Current instance of the singleton.
     */
    private static final EarlyInitSingleton INSTANCE = new EarlyInitSingleton();

    /**
     * Returns the current instance of the singleton.
     *
     * @return the current instance of the singleton
     */
    public static EarlyInitSingleton getInstance() {
        return INSTANCE;
    }
}
