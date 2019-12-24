package com.sensiblemetrics.api.alpenidos.core.fsm3.events;

import com.sensiblemetrics.api.alpenidos.core.fsm3.model.OrderIdentifier;
import com.sensiblemetrics.api.alpenidos.core.fsm3.model.OrderStatus;

public class OrderOpenedEvent extends AbstractOrderEvent {

    private static final long serialVersionUID = 1L;

    public OrderOpenedEvent(OrderIdentifier identifier, OrderStatus oldStatus, OrderStatus newStatus) {
        super(identifier, oldStatus, newStatus);
    }
}
