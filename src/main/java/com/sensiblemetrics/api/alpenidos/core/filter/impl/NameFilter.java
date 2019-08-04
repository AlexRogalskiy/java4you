package com.sensiblemetrics.api.alpenidos.core.filter.impl;

import com.sensiblemetrics.api.alpenidos.core.filter.model.Order;

/**
 * Concrete implementation of filter. This filter checks if the input in the Name field is valid.
 * (alphanumeric)
 *
 * @author joshzambales
 */
public class NameFilter extends AbstractFilter {

    @Override
    public String execute(final Order order) {
        String result = super.execute(order);
        if (order.getName() == null
            || order.getName().isEmpty()
            || order.getName().matches(".*[^\\w|\\s]+.*")) {
            return result + "Invalid name! ";
        }
        return result;
    }
}
