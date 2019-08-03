package com.sensiblemetrics.api.alpenidos.core.data_transfer_object.impl;

import com.sensiblemetrics.api.alpenidos.core.data_transfer_object.model.CustomerDto;

import java.util.List;
import java.util.Objects;

/**
 * The resource class which serves customer information.
 * This class act as server in the demo. Which has all customer details.
 */
public class CustomerResource {
    private List<CustomerDto> customers;

    /**
     * @param customers initialize resource with existing customers. Act as database.
     */
    public CustomerResource(final List<CustomerDto> customers) {
        this.customers = Objects.requireNonNull(customers);
    }

    /**
     * @return : all customers in list.
     */
    public List<CustomerDto> getAllCustomers() {
        return this.customers;
    }

    /**
     * @param customer save new customer to list.
     */
    public void save(final CustomerDto customer) {
        this.customers.add(customer);
    }

    /**
     * @param customerId delete customer with id {@code customerId}
     */
    public void delete(final String customerId) {
        this.customers.removeIf(customer -> customer.getId().equals(customerId));
    }
}
