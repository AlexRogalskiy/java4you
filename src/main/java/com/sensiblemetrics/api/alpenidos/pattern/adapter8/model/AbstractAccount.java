package com.sensiblemetrics.api.alpenidos.pattern.adapter8.model;

import java.math.BigDecimal;


/**
 * Abstract Account holds all the bits n pieces common to all Account types.
 */
public class AbstractAccount implements Account {

    private BigDecimal balance;
    private final boolean isOverdraftAvailable;

    public AbstractAccount(BigDecimal size, boolean isOverdraftAvailable) {
        this.balance = size;
        this.isOverdraftAvailable = isOverdraftAvailable;
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public boolean isOverdraftAvailable() {
        return isOverdraftAvailable;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " Balance=" + getBalance() + " Overdraft:" + isOverdraftAvailable();
    }

    @Override
    public void creditAccount(BigDecimal credit) {
        balance = balance.add(credit);
    }
}
