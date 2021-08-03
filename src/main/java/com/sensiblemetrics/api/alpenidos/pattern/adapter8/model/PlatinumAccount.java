package com.sensiblemetrics.api.alpenidos.pattern.adapter8.model;

import java.math.BigDecimal;

/**
 * Platinum Account holder can have overdraft.
 */
public class PlatinumAccount extends AbstractAccount {

    public PlatinumAccount(final BigDecimal balance) {
        super(balance, true);
    }
}
