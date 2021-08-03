package com.sensiblemetrics.api.alpenidos.pattern.fsm3.events;

import com.sensiblemetrics.api.alpenidos.pattern.fsm3.model.OrderIdentifier;
import com.sensiblemetrics.api.alpenidos.pattern.fsm3.model.OrderStatus;

public class OrderRevertedEvent extends AbstractOrderEvent {

    private static final long serialVersionUID = 1L;

    public OrderRevertedEvent(OrderIdentifier identifier, OrderStatus oldStatus, OrderStatus newStatus) {
        super(identifier, oldStatus, newStatus);
    }
}
