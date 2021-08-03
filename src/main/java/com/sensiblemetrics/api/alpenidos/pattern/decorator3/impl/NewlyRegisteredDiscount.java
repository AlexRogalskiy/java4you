package com.sensiblemetrics.api.alpenidos.pattern.decorator3.impl;

import com.sensiblemetrics.api.alpenidos.pattern.decorator3.iface.Discount;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class NewlyRegisteredDiscount implements Discount {

    public static final BigDecimal SEVENTY_FIVE = new BigDecimal(75);
    public static final BigDecimal ONE_HUNDRED = new BigDecimal(100);

    @Override
    public BigDecimal apply(final BigDecimal originalPrice) {
        return originalPrice.multiply(SEVENTY_FIVE).divide(ONE_HUNDRED, RoundingMode.CEILING);
    }

}
