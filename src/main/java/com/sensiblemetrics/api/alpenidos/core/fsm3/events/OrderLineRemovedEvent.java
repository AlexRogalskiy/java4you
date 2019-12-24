package com.sensiblemetrics.api.alpenidos.core.fsm3.events;

import com.sensiblemetrics.api.alpenidos.core.fsm3.model.OrderIdentifier;
import com.sensiblemetrics.api.alpenidos.core.fsm3.model.OrderLine;
import com.sensiblemetrics.api.alpenidos.core.fsm3.model.OrderLineIdentifier;
import com.sensiblemetrics.api.alpenidos.core.fsm3.model.OrderStatus;

import static java.util.Objects.requireNonNull;

public class OrderLineRemovedEvent extends AbstractOrderLineEvent {

    private static final long serialVersionUID = 1L;

    private OrderLine removedOrderLine;

    public OrderLineRemovedEvent(OrderIdentifier identifier, OrderStatus status, OrderLineIdentifier orderLineIdentifier, OrderLine removedOrderLine) {
        super(identifier, status, orderLineIdentifier);
        this.removedOrderLine = requireNonNull(removedOrderLine);
    }

    public OrderLine getRemovedOrderLine() {
        return removedOrderLine;
    }

}
