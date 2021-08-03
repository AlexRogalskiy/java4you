package com.sensiblemetrics.api.alpenidos.pattern.hexagonal.banking;

/**
 * Interface to bank accounts.
 */
public interface WireTransfers {

    /**
     * Set amount of funds for bank account
     */
    void setFunds(final String bankAccount, final int amount);

    /**
     * Get amount of funds for bank account
     */
    int getFunds(final String bankAccount);

    /**
     * Transfer funds from one bank account to another
     */
    boolean transferFunds(final int amount, final String sourceBackAccount, final String destinationBankAccount);
}
