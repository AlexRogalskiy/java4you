package com.sensiblemetrics.api.alpenidos.pattern.fsm3.state;

import com.sensiblemetrics.api.alpenidos.pattern.fsm3.model.Order;
import com.sensiblemetrics.api.alpenidos.pattern.fsm3.model.OrderDetails;

public class NewOrderState extends OrderStateAdapter implements OrderState {

    @Override
    public boolean canOpen() {
        return true;
    }

    @Override
    public void open(Order order) {
        order.doOpen();
    }

    @Override
    public boolean canUpdate() {
        return true;
    }

    @Override
    public void update(Order order, OrderDetails details) {
        order.doUpdate(details);
    }

}
