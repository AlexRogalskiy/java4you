package com.sensiblemetrics.api.alpenidos.core.commander.employee_service;

import com.sensiblemetrics.api.alpenidos.core.commander.model.Order;
import com.sensiblemetrics.api.alpenidos.core.commander.impl.Service;
import com.sensiblemetrics.api.alpenidos.core.commander.exception.DatabaseUnavailableException;

/**
 * The EmployeeHandle class is the middle-man between {@link Commander} and
 * {@link EmployeeDatabase}.
 */
public class EmployeeHandle extends Service {

    public EmployeeHandle(final EmployeeDatabase db, final Exception... exc) {
        super(db, exc);
    }

    public String receiveRequest(final Object... parameters) throws DatabaseUnavailableException {
        return updateDb((Order) parameters[0]);
    }

    protected String updateDb(final Object... parameters) throws DatabaseUnavailableException {
        final Order o = (Order) parameters[0];
        if (database.get(o.id) == null) {
            database.add(o);
            return o.id; //true rcvd - change addedToEmployeeHandle to true else dont do anything
        }
        return null;
    }
}
