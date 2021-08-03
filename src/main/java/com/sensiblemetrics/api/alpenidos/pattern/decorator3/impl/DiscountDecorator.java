package com.sensiblemetrics.api.alpenidos.pattern.decorator3.impl;

import com.sensiblemetrics.api.alpenidos.pattern.decorator3.iface.Discount;
import java.math.BigDecimal;

public class DiscountDecorator implements Discount {

    protected final Discount discount;

    public DiscountDecorator(final Discount discount) {
        this.discount = discount;
    }

    @Override
    public BigDecimal apply(BigDecimal originalPrice) {
        return discount.apply(originalPrice);
    }
}
