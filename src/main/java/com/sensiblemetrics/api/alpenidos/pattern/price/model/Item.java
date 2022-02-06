package com.sensiblemetrics.api.alpenidos.pattern.price.model;

import java.math.BigDecimal;

public class Item {
    private final long id;
    private final BigDecimal price;

    public Item(final long id, final BigDecimal price) {
        this.id = id;
        this.price = price;
    }

    public long id() {
        return id;
    }

    public BigDecimal price() {
        return price;
    }
}
