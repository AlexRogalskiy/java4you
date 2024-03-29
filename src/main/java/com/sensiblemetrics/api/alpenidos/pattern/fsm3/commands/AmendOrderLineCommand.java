package com.sensiblemetrics.api.alpenidos.pattern.fsm3.commands;

import com.sensiblemetrics.api.alpenidos.pattern.fsm3.model.OrderLine;
import com.sensiblemetrics.api.alpenidos.pattern.fsm3.model.OrderLineIdentifier;

import static java.util.Objects.requireNonNull;

public class AmendOrderLineCommand {

    private OrderLineIdentifier identifier;

    private OrderLine newOrderLine;

    private AmendOrderLineCommand(OrderLineIdentifier identifier, OrderLine newOrderLine) {
        this.identifier = identifier;
        this.newOrderLine = newOrderLine;
    }

    public static AmendOrderLineCommand changeOrderLineCommand(OrderLineIdentifier identifier, OrderLine newOrderLine) {
        return new AmendOrderLineCommand(requireNonNull(identifier), requireNonNull(newOrderLine));
    }

    public static AmendOrderLineCommand addOrderLineCommand(OrderLine newOrderLine) {
        return new AmendOrderLineCommand(null, requireNonNull(newOrderLine));
    }

    public static AmendOrderLineCommand removeOrderLineCommand(OrderLineIdentifier identifier) {
        return new AmendOrderLineCommand(requireNonNull(identifier), null);
    }

    public OrderLineIdentifier getIdentifier() {
        return identifier;
    }

    public OrderLine getNewOrderLine() {
        return newOrderLine;
    }

    public boolean isChanging() {
        return identifier != null && newOrderLine != null;
    }

    public boolean isAdding() {
        return identifier == null && newOrderLine != null;
    }

    public boolean isRemoving() {
        return identifier != null && newOrderLine == null;
    }

}
