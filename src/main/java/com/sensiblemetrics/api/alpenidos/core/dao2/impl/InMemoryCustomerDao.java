package com.sensiblemetrics.api.alpenidos.core.dao2.impl;

import com.sensiblemetrics.api.alpenidos.core.dao2.iface.CustomerDao;
import com.sensiblemetrics.api.alpenidos.core.dao2.model.Customer;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * An in memory implementation of {@link CustomerDao}, which stores the customers in JVM memory
 * and data is lost when the application exits.
 * <br>
 * This implementation is useful as temporary database or for testing.
 */
public class InMemoryCustomerDao implements CustomerDao {

    private final Map<Integer, Customer> idToCustomer = new HashMap<>();

    /**
     * An eagerly evaluated stream of customers stored in memory.
     */
    @Override
    public Stream<Customer> getAll() {
        return this.idToCustomer.values().stream();
    }

    @Override
    public Optional<Customer> getById(final int id) {
        return Optional.ofNullable(this.idToCustomer.get(id));
    }

    @Override
    public boolean add(final Customer customer) {
        if (getById(customer.getId()).isPresent()) {
            return false;
        }
        this.idToCustomer.put(customer.getId(), customer);
        return true;
    }

    @Override
    public boolean update(final Customer customer) {
        return this.idToCustomer.replace(customer.getId(), customer) != null;
    }

    @Override
    public boolean delete(final Customer customer) {
        return this.idToCustomer.remove(customer.getId()) != null;
    }
}
