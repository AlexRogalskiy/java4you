package com.sensiblemetrics.api.alpenidos.pattern.adapter8.model;

import java.math.BigDecimal;

/**
 * Standard Account holder cannot have overdraft.
 */
public class StandardAccount extends AbstractAccount {

    public StandardAccount(final BigDecimal balance) {
        super(balance, false);
    }
}
