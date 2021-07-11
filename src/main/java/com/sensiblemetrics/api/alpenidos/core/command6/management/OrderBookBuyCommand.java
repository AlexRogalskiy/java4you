package com.sensiblemetrics.api.alpenidos.core.command6.management;

import com.sensiblemetrics.api.alpenidos.core.command6.model.Order;
import com.sensiblemetrics.api.alpenidos.core.command6.receiver.OrderBook;

/**
 * Concrete Command for placing a BUY order.
 * <p>
 */
public class OrderBookBuyCommand implements OrderCommand {

    /**
     * The Order Book is the receiver
     */
    private final OrderBook orderBook;

    /**
     * Constructs the command with the Recevier.
     *
     * @param orderBook the receiver the command will perform operations on.
     */
    public OrderBookBuyCommand(OrderBook orderBook) {
        this.orderBook = orderBook;
    }

    @Override
    public void execute(Order order) {
        orderBook.updateBuyOrders(order);
    }
}
