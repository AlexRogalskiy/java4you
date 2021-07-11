package com.sensiblemetrics.api.alpenidos.core.builder5.model.customer;

import com.sensiblemetrics.api.alpenidos.core.builder5.model.account.Account;

/**
 * The root of the Borrowing Customer hierarchy.
 *
 * @author gazber
 */
public abstract class BorrowingCustomer extends AbstractCustomer {

    public BorrowingCustomer(final Account account) {
        super(account);
    }
}
