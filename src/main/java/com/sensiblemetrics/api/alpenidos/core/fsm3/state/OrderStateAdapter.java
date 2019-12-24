package com.sensiblemetrics.api.alpenidos.core.fsm3.state;

import com.sensiblemetrics.api.alpenidos.core.fsm3.exception.IllegalOrderStateException;
import com.sensiblemetrics.api.alpenidos.core.fsm3.commands.AmendOrderLineCommand;
import com.sensiblemetrics.api.alpenidos.core.fsm3.model.Order;
import com.sensiblemetrics.api.alpenidos.core.fsm3.model.OrderDetails;

public class OrderStateAdapter implements OrderState {

    @Override
    public boolean canOpen() {
        return false;
    }

    @Override
    public void open(final Order order) {
        throw new IllegalOrderStateException(order, "open");
    }

    @Override
    public boolean canClose() {
        return false;
    }

    @Override
    public void close(final Order order) {
        throw new IllegalOrderStateException(order, "close");
    }

    @Override
    public boolean canSuspend() {
        return false;
    }

    @Override
    public void suspend(final Order order, final String reason) {
        throw new IllegalOrderStateException(order, "suspend");
    }

    @Override
    public boolean canResume() {
        return false;
    }

    @Override
    public void resume(final Order order) {
        throw new IllegalOrderStateException(order, "resume");
    }

    @Override
    public boolean canCancel() {
        return false;
    }

    @Override
    public void cancel(final Order order, final String reason) {
        throw new IllegalOrderStateException(order, "cancel");
    }

    @Override
    public boolean canUpdate() {
        return false;
    }

    @Override
    public void update(final Order order, final OrderDetails details) {
        throw new IllegalOrderStateException(order, "update");
    }

    @Override
    public boolean canRevert() {
        return false;
    }

    @Override
    public void revert(Order order) {
        throw new IllegalOrderStateException(order, "revert");
    }

    @Override
    public boolean canRequestForInformation() {
        return false;
    }

    @Override
    public void requestForInformation(final Order order, final String request) {
        throw new IllegalOrderStateException(order, "request for information");
    }

    @Override
    public boolean canAmendOrderLine() {
        return false;
    }

    @Override
    public void amendOrderLine(final Order order, final AmendOrderLineCommand command) {
        throw new IllegalOrderStateException(order, "amend order line");
    }
}
