package com.sensiblemetrics.api.alpenidos.pattern.fsm3.model;

import com.sensiblemetrics.api.alpenidos.pattern.fsm3.commands.AmendOrderLineCommand;
import com.sensiblemetrics.api.alpenidos.pattern.fsm3.events.*;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.requireNonNull;

public class Order {
    private OrderStatus status;
    private OrderIdentifier identifier;
    private OrderDetails details;
    private List<Event> pendingEvents = new ArrayList<>();

    public Order(final OrderStatus status, final OrderIdentifier identifier, final OrderDetails details) {
        this.status = requireNonNull(status);
        this.identifier = requireNonNull(identifier);
        this.details = requireNonNull(details);
        this.pendingEvents.add(new OrderPlacedEvent(identifier, status, details));
    }

    public Iterable<Event> getPendingEvents() {
        return this.pendingEvents;
    }

    public OrderStatus getStatus() {
        return this.status;
    }

    public OrderIdentifier getIdentifier() {
        return this.identifier;
    }

    public OrderDetails getDetails() {
        return this.details;
    }

    public void open() {
        this.status.open(this);
    }

    public void doOpen() {
        final OrderStatus oldStatus = this.status;
        this.status = OrderStatus.OPENED;
        this.pendingEvents.add(new OrderOpenedEvent(identifier, oldStatus, this.status));
    }

    public void close() {
        this.status.close(this);
    }

    public void doClose() {
        final OrderStatus oldStatus = this.status;
        this.status = OrderStatus.CLOSED;
        this.pendingEvents.add(new OrderClosedEvent(identifier, oldStatus, this.status));
    }

    public void suspend(String reason) {
        this.status.suspend(this, reason);
    }

    public void doSuspend(final String reason) {
        requireNonNull(reason);

        final OrderStatus oldStatus = this.status;
        this.status = OrderStatus.SUSPENDED;
        this.pendingEvents.add(new OrderSuspendedEvent(this.identifier, oldStatus, this.status, reason));
    }

    public void resume() {
        this.status.resume(this);
    }

    public void doResume() {
        final OrderStatus oldStatus = this.status;
        this.status = OrderStatus.OPENED;
        pendingEvents.add(new OrderResumedEvent(identifier, oldStatus, this.status));
    }

    public void cancel(String reason) {
        this.status.cancel(this, reason);
    }

    public void doCancel(String reason) {
        requireNonNull(reason);

        final OrderStatus oldStatus = this.status;
        this.status = OrderStatus.CANCELLED;
        pendingEvents.add(new OrderCancelledEvent(identifier, oldStatus, this.status, reason));
    }

    public void update(final OrderDetails details) {
        this.status.update(this, details);
    }

    public void doUpdate(final OrderDetails details) {
        if (this.details.equals(details)) {
            return;
        }
        final OrderDetails oldDetails = this.details;
        this.details = requireNonNull(details);
        this.pendingEvents.add(new OrderUpdatedEvent(identifier, this.status, oldDetails, details));
    }

    public void revert() {
        this.status.revert(this);
    }

    public void doRevert() {
        final OrderStatus oldStatus = this.status;
        this.status = OrderStatus.NEW;
        this.pendingEvents.add(new OrderRevertedEvent(this.identifier, oldStatus, this.status));
    }

    public void requestForInformation(final String request) {
        status.requestForInformation(this, request);
    }

    public void doRequestForInformation(final String request) {
        requireNonNull(request);

        final OrderStatus oldStatus = this.status;
        this.status = OrderStatus.NEW;
        this.pendingEvents.add(new OrderRequestedForInformationEvent(identifier, oldStatus, this.status, request));
    }

    public void amendOrderLine(final AmendOrderLineCommand command) {
        this.status.amendOrderLine(this, command);
    }

    public void doAmendOrderLine(final AmendOrderLineCommand command) {
        requireNonNull(command);

        final OrderLineIdentifier orderLineIdentifier = command.getIdentifier();
        final OrderLine newOrderLine = command.getNewOrderLine();
        if (command.isChanging()) {
            final OrderLine oldOrderLine = details.changeOrderLine(orderLineIdentifier, command.getNewOrderLine());
            this.pendingEvents.add(new OrderLineChangedEvent(identifier, this.status, orderLineIdentifier, oldOrderLine, newOrderLine));
        }
        if (command.isAdding()) {
            final boolean added = details.addOrderLine(newOrderLine);
            if (added) {
                this.pendingEvents.add(new OrderLineAddedEvent(identifier, this.status, newOrderLine.getIdentifier(), newOrderLine));
            }
        }
        if (command.isRemoving()) {
            final OrderLine oldOrderLine = details.removeOrderLine(orderLineIdentifier);
            this.pendingEvents.add(new OrderLineRemovedEvent(identifier, this.status, orderLineIdentifier, oldOrderLine));
        }
    }
}
