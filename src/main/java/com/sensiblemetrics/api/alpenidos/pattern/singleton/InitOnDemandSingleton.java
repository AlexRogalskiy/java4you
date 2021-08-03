package com.sensiblemetrics.api.alpenidos.pattern.singleton;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Initialization on demand singleton pattern. Uses a nested static class to
 * hold a reference to the singleton instance.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InitOnDemandSingleton {
    /**
     * Holder for a singleton instance.
     *
     * @author Donato Rimenti
     */
    private static class InstanceHolder {
        /**
         * Current instance of the singleton.
         */
        private static final InitOnDemandSingleton INSTANCE = new InitOnDemandSingleton();
    }

    /**
     * Returns the current instance of the singleton.
     *
     * @return the current instance of the singleton
     */
    public static InitOnDemandSingleton getInstance() {
        return InstanceHolder.INSTANCE;
    }
}
