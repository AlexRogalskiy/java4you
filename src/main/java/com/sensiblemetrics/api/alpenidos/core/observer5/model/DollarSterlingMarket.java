package com.sensiblemetrics.api.alpenidos.core.observer5.model;

/**
 * A Subject. Also called a Concrete Observable.
 */
public final class DollarSterlingMarket extends Market {

    /**
     * 1 single instance of this on the exchange for obvious reasons!
     */
    private static final DollarSterlingMarket SINGLE_INSTANCE = new DollarSterlingMarket();

    // lockdown
    private DollarSterlingMarket() {
    }

    /**
     * Returns market.
     *
     * @return the single instance
     */
    public static Market getInstance() {
        return SINGLE_INSTANCE;
    }
}
