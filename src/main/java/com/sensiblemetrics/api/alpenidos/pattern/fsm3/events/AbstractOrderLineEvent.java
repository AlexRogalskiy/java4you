package com.sensiblemetrics.api.alpenidos.pattern.fsm3.events;

import com.sensiblemetrics.api.alpenidos.pattern.fsm3.model.OrderIdentifier;
import com.sensiblemetrics.api.alpenidos.pattern.fsm3.model.OrderLineIdentifier;
import com.sensiblemetrics.api.alpenidos.pattern.fsm3.model.OrderStatus;

import static java.util.Objects.requireNonNull;

public abstract class AbstractOrderLineEvent extends AbstractOrderEvent {

    private static final long serialVersionUID = 1L;

    private OrderLineIdentifier orderLineIdentifier;

    public AbstractOrderLineEvent(OrderIdentifier identifier, OrderStatus status, OrderLineIdentifier orderLineIdentifier) {
        super(identifier, status);
        this.orderLineIdentifier = requireNonNull(orderLineIdentifier);
    }

    public OrderLineIdentifier getOrderLineIdentifier() {
        return orderLineIdentifier;
    }

}
