package com.sensiblemetrics.api.alpenidos.core.fsm3.events;

import com.sensiblemetrics.api.alpenidos.core.fsm3.OrderDetails;
import com.sensiblemetrics.api.alpenidos.core.fsm3.OrderIdentifier;
import com.sensiblemetrics.api.alpenidos.core.fsm3.OrderStatus;

import static java.util.Objects.requireNonNull;

public class OrderPlacedEvent extends AbstractOrderEvent {

    private static final long serialVersionUID = 1L;

    private OrderDetails details;

    public OrderPlacedEvent(OrderIdentifier identifier, OrderStatus status, OrderDetails details) {
        super(identifier, status, status);
        this.details = requireNonNull(details);
    }

    public OrderDetails getDetails() {
        return details;
    }
}
