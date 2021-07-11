package com.sensiblemetrics.api.alpenidos.core.command6.receiver;

import com.sensiblemetrics.api.alpenidos.core.command6.model.Order;

/**
 * A Receiver.
 * <p>
 * This is the Order Book. Massively simplified for the demo!
 * <p>
 */
public class OrderBook {

    public void updateBuyOrders(Order order) {
        System.out.println(OrderBook.class.getSimpleName() + " - updating the Order Book BUY order: "
            + "id=" + order.getId()
            + " amount=" + order.getAmount()
            + " price= " + order.getPrice());
    }

    public void updateSellOrders(Order order) {
        System.out.println(OrderBook.class.getSimpleName() + " - updating the Order Book SELL order: "
            + "id=" + order.getId()
            + "amount=" + order.getAmount()
            + " price= " + order.getPrice());
    }

    public void cancelOrder(Order order) {
        System.out.println(OrderBook.class.getSimpleName() + " - cancelling order for order:"
            + " id=" + order.getId()
            + " amount=" + order.getAmount());
    }
}
