package com.sensiblemetrics.api.alpenidos.core.command6.management;

import com.sensiblemetrics.api.alpenidos.core.command6.model.Order;
import com.sensiblemetrics.api.alpenidos.core.command6.receiver.OrderBook;

/**
 * Concrete Command for placing a SELL order.
 */
public class OrderBookSellCommand implements OrderCommand {

    /**
     * The Order Book is the receiver
     */
    private final OrderBook orderBook;

    /**
     * Constructs the command with the Recevier.
     *
     * @param orderBook the receiver the command will perform operations on.
     */
    public OrderBookSellCommand(OrderBook orderBook) {
        this.orderBook = orderBook;
    }

    @Override
    public void execute(Order order) {
        orderBook.updateSellOrders(order);
    }
}
