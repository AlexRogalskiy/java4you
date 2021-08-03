package com.sensiblemetrics.api.alpenidos.pattern.command6.management;

import com.sensiblemetrics.api.alpenidos.pattern.command6.model.Order;
import com.sensiblemetrics.api.alpenidos.pattern.command6.receiver.OrderBook;

/**
 * Concrete Command for cancelling an order.
 */
public class OrderBookCancelCommand implements OrderCommand {

    /**
     * The Order Book is the receiver
     */
    private final OrderBook orderBook;

    /**
     * Constructs the command with the Recevier.
     *
     * @param orderBook the receiver the command will perform operations on.
     */
    public OrderBookCancelCommand(OrderBook orderBook) {
        this.orderBook = orderBook;
    }

    @Override
    public void execute(Order order) {
        orderBook.cancelOrder(order);
    }
}
