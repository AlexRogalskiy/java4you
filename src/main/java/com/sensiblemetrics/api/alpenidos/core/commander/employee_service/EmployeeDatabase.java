package com.sensiblemetrics.api.alpenidos.core.commander.employee_service;

import com.sensiblemetrics.api.alpenidos.core.commander.impl.Database;
import com.sensiblemetrics.api.alpenidos.core.commander.model.Order;
import com.sensiblemetrics.api.alpenidos.core.commander.exception.DatabaseUnavailableException;
import lombok.RequiredArgsConstructor;

import java.util.Hashtable;

/**
 * The Employee Database is where orders which have encountered some issue(s) are added.
 */
@RequiredArgsConstructor
public class EmployeeDatabase extends Database<Order> {
    private final Hashtable<String, Order> data;

    public EmployeeDatabase() {
        this(new Hashtable<>());
    }

    @Override
    public Order add(final Order o) throws DatabaseUnavailableException {
        return this.data.put(o.id, o);
    }

    @Override
    public Order get(final String oId) throws DatabaseUnavailableException {
        return this.data.get(oId);
    }
}
