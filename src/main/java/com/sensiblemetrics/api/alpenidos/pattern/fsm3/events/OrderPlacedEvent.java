package com.sensiblemetrics.api.alpenidos.pattern.fsm3.events;

import com.sensiblemetrics.api.alpenidos.pattern.fsm3.model.OrderDetails;
import com.sensiblemetrics.api.alpenidos.pattern.fsm3.model.OrderIdentifier;
import com.sensiblemetrics.api.alpenidos.pattern.fsm3.model.OrderStatus;

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
