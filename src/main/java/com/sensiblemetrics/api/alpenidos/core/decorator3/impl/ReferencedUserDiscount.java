package com.sensiblemetrics.api.alpenidos.core.decorator3.impl;

import com.sensiblemetrics.api.alpenidos.core.decorator3.iface.Discount;
import java.math.BigDecimal;

public class ReferencedUserDiscount extends DiscountDecorator {

    public static final BigDecimal FIVE = new BigDecimal(5);

    public ReferencedUserDiscount(final Discount discount) {
        super(discount);
    }

    @Override
    public BigDecimal apply(BigDecimal originalPrice) {
        final BigDecimal discountedPrice = super.apply(originalPrice);

        if (discountedPrice.compareTo(FIVE) <= 0) {
            return discountedPrice;
        }

        return discountedPrice.subtract(FIVE);
    }
}
