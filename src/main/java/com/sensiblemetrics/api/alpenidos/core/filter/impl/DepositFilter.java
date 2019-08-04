package com.sensiblemetrics.api.alpenidos.core.filter.impl;

import com.sensiblemetrics.api.alpenidos.core.filter.model.Order;

/**
 * Concrete implementation of filter This checks for the deposit code
 *
 * @author joshzambales
 */
public class DepositFilter extends AbstractFilter {

    @Override
    public String execute(final Order order) {
        String result = super.execute(order);
        if (order.getDepositNumber() == null || order.getDepositNumber().isEmpty()) {
            return result + "Invalid deposit number! ";
        }
        return result;
    }
}
