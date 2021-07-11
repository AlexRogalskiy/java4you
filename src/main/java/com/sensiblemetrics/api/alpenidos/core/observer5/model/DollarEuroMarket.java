package com.sensiblemetrics.api.alpenidos.core.observer5.model;

/**
 * A Subject. Also called a Concrete Observable.
 */
public class DollarEuroMarket extends Market {

    /**
     * 1 single instance of this on the exchange for obvious reasons!
     */
    private static final DollarEuroMarket SINGLE_INSTANCE = new DollarEuroMarket();

    // lockdown
    private DollarEuroMarket() {
    }

    /**
     * Returns market.
     *
     * @return the single instance of the market.
     */
    public static Market getInstance() {
        return SINGLE_INSTANCE;
    }
}
