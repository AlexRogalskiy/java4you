package com.sensiblemetrics.api.alpenidos.core.filter.impl;

import com.sensiblemetrics.api.alpenidos.core.filter.model.Order;

/**
 * Concrete implementation of filter. This checks for the order field.
 *
 * @author joshzambales
 */
public class OrderFilter extends AbstractFilter {

    @Override
    public String execute(final Order order) {
        final String result = super.execute(order);
        if (order.getOrderItem() == null || order.getOrderItem().isEmpty()) {
            return result + "Invalid order! ";
        }
        return result;
    }
}
