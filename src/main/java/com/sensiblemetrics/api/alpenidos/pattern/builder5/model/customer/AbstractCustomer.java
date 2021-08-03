package com.sensiblemetrics.api.alpenidos.pattern.builder5.model.customer;

import com.sensiblemetrics.api.alpenidos.pattern.builder5.model.account.Account;
import com.sensiblemetrics.api.alpenidos.pattern.builder5.model.address.Address;

/**
 * Abstract Customer holds all the bits n pieces common to all Customer types.
 */
public abstract class AbstractCustomer implements Customer {

    /**
     * Reference to the Account we have built for this Customer
     */
    private final Account account;

    public AbstractCustomer(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public String toString() {
        return getClass().getSimpleName() + " Account:" + account;
    }

    public void setAddress(Address address) {
    }
}
