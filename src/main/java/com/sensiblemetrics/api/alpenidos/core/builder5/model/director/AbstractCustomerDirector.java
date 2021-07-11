package com.sensiblemetrics.api.alpenidos.core.builder5.model.director;

import com.sensiblemetrics.api.alpenidos.core.builder5.management.AbstractCustomerBuilder;
import com.sensiblemetrics.api.alpenidos.core.builder5.model.customer.Customer;

/**
 * Abstract Director for all Concrete Directors to extend from.
 */
public abstract class AbstractCustomerDirector<T extends AbstractCustomerBuilder> {

    public abstract Customer build(T builder);
}
