package com.sensiblemetrics.api.alpenidos.core.decorator4.model;

import java.math.BigDecimal;

/**
 * This is the Component.
 */
public interface Account {

    String getType();

    BigDecimal getBalance();

    void credit(BigDecimal credit);

    void debit(BigDecimal debit);
}
