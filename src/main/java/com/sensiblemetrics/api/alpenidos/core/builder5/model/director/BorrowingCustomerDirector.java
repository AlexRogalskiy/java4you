package com.sensiblemetrics.api.alpenidos.core.builder5.model.director;

import com.sensiblemetrics.api.alpenidos.core.builder5.management.BorrowingCustomerBuilder;
import com.sensiblemetrics.api.alpenidos.core.builder5.model.customer.Customer;

/**
 * Concrete Director impl for assembling a Borrowing Customer.
 * <p>
 * The Director decides what builder methods to call and in what order.
 * <p>
 * Tells the Builder what to build and at what point to return what it has built to date.
 */
public class BorrowingCustomerDirector extends AbstractCustomerDirector<BorrowingCustomerBuilder> {

    @Override
    public Customer build(BorrowingCustomerBuilder builder) {
        builder.buildContactDetails();
        builder.buildEmployerDetails();

        // for borrowers only
        builder.buildCreditRatingReport();

        builder.buildSalesOpportunities();
        builder.buildMarketingPreferences();

        return builder.getCustomer();
    }
}
