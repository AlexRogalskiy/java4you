package com.sensiblemetrics.api.alpenidos.pattern.fsm3.events;

import com.sensiblemetrics.api.alpenidos.pattern.fsm3.model.OrderIdentifier;
import com.sensiblemetrics.api.alpenidos.pattern.fsm3.model.OrderLine;
import com.sensiblemetrics.api.alpenidos.pattern.fsm3.model.OrderLineIdentifier;
import com.sensiblemetrics.api.alpenidos.pattern.fsm3.model.OrderStatus;

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
