package com.sensiblemetrics.api.alpenidos.pattern.builder5.model.customer;

import com.sensiblemetrics.api.alpenidos.pattern.builder5.model.account.Account;

/**
 * The root of the Investing Customer hierarchy.
 */
public abstract class InvestingCustomer extends AbstractCustomer {

    public InvestingCustomer(final Account account) {
        super(account);
    }
}
