package com.sensiblemetrics.api.alpenidos.core.adapter8.model;

import com.sensiblemetrics.api.alpenidos.core.adapter8.model.AbstractAccount;
import java.math.BigDecimal;

/**
 * Platinum Account holder can have overdraft.
 */
public class PlatinumAccount extends AbstractAccount {

    public PlatinumAccount(final BigDecimal balance) {
        super(balance, true);
    }
}
