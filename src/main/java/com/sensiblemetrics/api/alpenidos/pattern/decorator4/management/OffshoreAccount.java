package com.sensiblemetrics.api.alpenidos.pattern.decorator4.management;

import com.sensiblemetrics.api.alpenidos.pattern.decorator4.model.Account;
import java.math.BigDecimal;

/**
 * Concrete Decorator implementation for adding extra state for an Offshore account.
 * <p>
 * Offshore investments carry the highest broker fees.
 *
 */
public class OffshoreAccount extends AccountDecorator {

    private static final BigDecimal BROKER_FEE = new BigDecimal("0.5");

    /**
     * Constructor creates this Concrete Decorator.
     *
     * @param wrappedComponent the Account Component we are wrapping/decorating.
     */
    public OffshoreAccount(final Account wrappedComponent) {
        super(wrappedComponent);
    }

    @Override
    protected BigDecimal getBrokerFee() {
        return BROKER_FEE;
    }
}
