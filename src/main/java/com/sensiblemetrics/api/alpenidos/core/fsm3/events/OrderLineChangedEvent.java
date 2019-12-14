package com.sensiblemetrics.api.alpenidos.core.fsm3.events;

import com.sensiblemetrics.api.alpenidos.core.fsm3.OrderIdentifier;
import com.sensiblemetrics.api.alpenidos.core.fsm3.OrderLine;
import com.sensiblemetrics.api.alpenidos.core.fsm3.OrderLineIdentifier;
import com.sensiblemetrics.api.alpenidos.core.fsm3.OrderStatus;

import static java.util.Objects.requireNonNull;

public class OrderLineChangedEvent extends AbstractOrderLineEvent {

    private static final long serialVersionUID = 1L;

    private OrderLine oldOrderLine;

    private OrderLine newOrderLine;

    public OrderLineChangedEvent(OrderIdentifier identifier, OrderStatus status, OrderLineIdentifier orderLineIdentifier, OrderLine oldOrderLine, OrderLine newOrderLine) {
        super(identifier, status, orderLineIdentifier);
        this.oldOrderLine = requireNonNull(oldOrderLine);
        this.newOrderLine = requireNonNull(newOrderLine);
    }

    public OrderLine getOldOrderLine() {
        return oldOrderLine;
    }

    public OrderLine getNewOrderLine() {
        return newOrderLine;
    }

}
