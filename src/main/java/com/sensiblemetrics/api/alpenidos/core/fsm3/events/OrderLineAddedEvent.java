package com.sensiblemetrics.api.alpenidos.core.fsm3.events;

import com.sensiblemetrics.api.alpenidos.core.fsm3.OrderIdentifier;
import com.sensiblemetrics.api.alpenidos.core.fsm3.OrderLine;
import com.sensiblemetrics.api.alpenidos.core.fsm3.OrderLineIdentifier;
import com.sensiblemetrics.api.alpenidos.core.fsm3.OrderStatus;

import static java.util.Objects.requireNonNull;

public class OrderLineAddedEvent extends AbstractOrderLineEvent {

    private static final long serialVersionUID = 1L;

    private OrderLine addedOrderLine;

    public OrderLineAddedEvent(OrderIdentifier identifier, OrderStatus status, OrderLineIdentifier orderLineIdentifier, OrderLine addedOrderLine) {
        super(identifier, status, orderLineIdentifier);
        this.addedOrderLine = requireNonNull(addedOrderLine);
    }

    public OrderLine getAddedOrderLine() {
        return addedOrderLine;
    }
}
