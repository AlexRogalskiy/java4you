package com.sensiblemetrics.api.alpenidos.core.builder5.model.customer;

import com.sensiblemetrics.api.alpenidos.core.builder5.model.account.Account;

/**
 * This is the complex 'Product' we are going to build.
 * <p>
 * A Customer class hierarchy is:
 *
 * <pre>
 * Customer
 *           AbstractCustomer
 *                             InvestingCustomer
 *                                                SavingsCustomer, StockbrokingCustomer
 *                             BorrowingCustomer
 *                                                LoanCustomer, MortgageCustomer
 * </pre>
 * <p>
 * In reality it would be a lot more complex than this, but this will be enough for the demo!
 * <p>
 * A Customer will have a different Account depending on what type of Customer they are.
 * <p>
 * We also use an Abstract Factory pattern for building the objects in conjunction with this Builder pattern - I'm leaving this out to keep things simple (?!)
 * for now.
 */
public interface Customer {

    /**
     * Each Customer will have an Account. The way the Account is built depends on the type of Customer we have.
     *
     * @return the Customer's account.
     */
    Account getAccount();
}
