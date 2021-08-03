package com.sensiblemetrics.api.alpenidos.pattern.builder5.model.director;

import com.sensiblemetrics.api.alpenidos.pattern.builder5.management.InvestingCustomerBuilder;
import com.sensiblemetrics.api.alpenidos.pattern.builder5.model.customer.Customer;

/**
 * Concrete Director impl for assembling an Investing Customer.
 * <p>
 * The Director decides what builder methods to call and in what order.
 * <p>
 * Tells the Builder what to build and at what point to return what it has built to date.
 */
public class InvestingCustomerDirector extends AbstractCustomerDirector<InvestingCustomerBuilder> {

    @Override
    public Customer build(InvestingCustomerBuilder builder) {
        builder.buildContactDetails();
        builder.buildEmployerDetails();

        // for investors only
        builder.buildTaxationDetails();
        builder.buildRewardsScheme();

        builder.buildSalesOpportunities();
        builder.buildMarketingPreferences();

        return builder.getCustomer();
    }
}
