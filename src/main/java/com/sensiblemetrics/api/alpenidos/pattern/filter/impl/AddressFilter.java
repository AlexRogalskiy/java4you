package com.sensiblemetrics.api.alpenidos.pattern.filter.impl;

import com.sensiblemetrics.api.alpenidos.pattern.filter.model.Order;

/**
 * Concrete implementation of filter This filter is responsible for checking/filtering the input in
 * the address field.
 */
public class AddressFilter extends AbstractFilter {

    @Override
    public String execute(final Order order) {
        final String result = super.execute(order);
        if (order.getAddress() == null || order.getAddress().isEmpty()) {
            return result + "Invalid address! ";
        }
        return result;
    }
}
