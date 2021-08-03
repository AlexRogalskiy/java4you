package com.sensiblemetrics.api.alpenidos.pattern.builder5.model.account;

import java.math.BigDecimal;

/**
 * Standard Account holder.
 */
public class StandardAccount extends AbstractAccount {

    public StandardAccount(BigDecimal balance) {
        super(balance, false);
    }
}
