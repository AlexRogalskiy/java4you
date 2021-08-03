package com.sensiblemetrics.api.alpenidos.pattern.adapter8.model;

import java.math.BigDecimal;

/**
 * An Account.
 * <p>
 * There would be loads more stuff in here in the real world...
 */
public interface Account {

    BigDecimal getBalance();

    boolean isOverdraftAvailable();

    void creditAccount(final BigDecimal credit);
}
