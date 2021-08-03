package com.sensiblemetrics.api.alpenidos.pattern.command6.model;

import java.math.BigDecimal;

/**
 * Domain class for an order received on the exchange. Not part of the Command pattern per se.
 * <p>
 * Kept simple for the demo!
 * <p>
 */
public class Order {

    private final long id;
    private BigDecimal amount;
    private final BigDecimal price;

    /**
     * Constructor builds an order.
     *
     * @param id     the id
     * @param amount the amount
     * @param price  the price
     */
    public Order(long id, BigDecimal amount, BigDecimal price) {
        this.id = id;
        this.amount = price;
        this.price = price;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
