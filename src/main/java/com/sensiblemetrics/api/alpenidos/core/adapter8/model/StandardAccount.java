package com.sensiblemetrics.api.alpenidos.core.adapter8.model;

import com.sensiblemetrics.api.alpenidos.core.adapter8.model.AbstractAccount;
import java.math.BigDecimal;

/**
 * Standard Account holder cannot have overdraft.
 */
public class StandardAccount extends AbstractAccount {

    public StandardAccount(final BigDecimal balance) {
        super(balance, false);
    }
}
