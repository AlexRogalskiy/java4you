package com.sensiblemetrics.api.alpenidos.pattern.fsm3.events;

import com.sensiblemetrics.api.alpenidos.pattern.fsm3.model.OrderIdentifier;
import com.sensiblemetrics.api.alpenidos.pattern.fsm3.model.OrderStatus;

import static java.util.Objects.requireNonNull;

public class OrderRequestedForInformationEvent extends AbstractOrderEvent {

    private static final long serialVersionUID = 1L;

    private String request;

    public OrderRequestedForInformationEvent(OrderIdentifier identifier, OrderStatus oldStatus, OrderStatus newStatus, String request) {
        super(identifier, oldStatus, newStatus);
        this.request = requireNonNull(request);
    }

    public String getRequest() {
        return request;
    }
}
