package com.sensiblemetrics.api.alpenidos.pattern.decorator4.management;

import com.sensiblemetrics.api.alpenidos.pattern.decorator4.model.Account;
import java.math.BigDecimal;

/**
 * Concrete Decorator implementation for adding extra state for a Standard account.
 * <p>
 * Standard accounts are domicile and not within an ISA; they carry the 'standard' broker fees.
 */
public class StandardAccount extends AccountDecorator {

    private static final BigDecimal BROKER_FEE = new BigDecimal("0.3");

    /**
     * Constructor creates this Concrete Decorator.
     *
     * @param wrappedComponent the Account Component we are wrapping/decorating.
     */
    public StandardAccount(Account wrappedComponent) {
        super(wrappedComponent);
    }

    @Override
    protected BigDecimal getBrokerFee() {
        return BROKER_FEE;
    }
}
