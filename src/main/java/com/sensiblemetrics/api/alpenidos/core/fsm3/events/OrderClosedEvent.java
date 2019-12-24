package com.sensiblemetrics.api.alpenidos.core.fsm3.events;

import com.sensiblemetrics.api.alpenidos.core.fsm3.model.OrderIdentifier;
import com.sensiblemetrics.api.alpenidos.core.fsm3.model.OrderStatus;

public class OrderClosedEvent extends AbstractOrderEvent {

    private static final long serialVersionUID = 1L;

    public OrderClosedEvent(OrderIdentifier identifier, OrderStatus oldStatus, OrderStatus newStatus) {
        super(identifier, oldStatus, newStatus);
    }

}
