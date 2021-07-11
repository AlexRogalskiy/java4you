package com.sensiblemetrics.api.alpenidos.core.builder5.model.account;

import java.math.BigDecimal;

/**
 * Platinum Account holder.
 */
public class PlatinumAccount extends AbstractAccount {

    public PlatinumAccount(final BigDecimal balance) {
        super(balance, true);
    }
}
