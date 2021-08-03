package com.sensiblemetrics.api.alpenidos.pattern.fsm3.exception;

import com.sensiblemetrics.api.alpenidos.pattern.fsm3.model.Order;

import static java.util.Objects.requireNonNull;

public class IllegalOrderStateException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private Order order;

    private String operation;

    public IllegalOrderStateException(Order order, String operation) {
        this.order = requireNonNull(order);
        this.operation = requireNonNull(operation);
    }

    @Override
    public String getMessage() {
        return "Cannot " + operation + " on order '" + order.getIdentifier() + "' with status '" + order.getStatus()
                + "'.";
    }
}
