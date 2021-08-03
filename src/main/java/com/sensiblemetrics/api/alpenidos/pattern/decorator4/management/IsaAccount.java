package com.sensiblemetrics.api.alpenidos.pattern.decorator4.management;

import com.sensiblemetrics.api.alpenidos.pattern.decorator4.model.Account;
import java.math.BigDecimal;

/**
 * Concrete Decorator implementation for adding extra state for a UK ISA (government backed tax-free savings) account.
 * <p>
 * The broker fee is less to encourage the public to invest more...
 */
public class IsaAccount extends AccountDecorator {

    private static final BigDecimal BROKER_FEE = new BigDecimal("0.1");

    /**
     * Constructor creates this Concrete Decorator.
     *
     * @param wrappedComponent the Account Component we are wrapping/decorating.
     */
    public IsaAccount(Account wrappedComponent) {
        super(wrappedComponent);
    }

    @Override
    protected BigDecimal getBrokerFee() {
        return BROKER_FEE;
    }
}
