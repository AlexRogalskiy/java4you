package com.sensiblemetrics.api.alpenidos.pattern.fsm3.events;

import com.sensiblemetrics.api.alpenidos.pattern.fsm3.model.OrderIdentifier;
import com.sensiblemetrics.api.alpenidos.pattern.fsm3.model.OrderStatus;

import static java.util.Objects.requireNonNull;

public class OrderCancelledEvent extends AbstractOrderEvent {

    private static final long serialVersionUID = 1L;

    private String reason;

    public OrderCancelledEvent(OrderIdentifier identifier, OrderStatus oldStatus, OrderStatus newStatus, String reason) {
        super(identifier, oldStatus, newStatus);
        this.reason = requireNonNull(reason);
    }

    public String getReason() {
        return reason;
    }

}
