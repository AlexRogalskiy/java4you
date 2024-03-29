package com.sensiblemetrics.api.alpenidos.pattern.fsm3.state;

import com.sensiblemetrics.api.alpenidos.pattern.fsm3.model.Order;

public class SuspendedOrderState extends OrderStateAdapter implements OrderState {

    @Override
    public boolean canClose() {
        return true;
    }

    @Override
    public void close(Order order) {
        order.doClose();
    }

    @Override
    public boolean canResume() {
        return true;
    }

    @Override
    public void resume(Order order) {
        order.doResume();
    }

    @Override
    public boolean canCancel() {
        return true;
    }

    @Override
    public void cancel(Order order, String reason) {
        order.doCancel(reason);
    }

}
