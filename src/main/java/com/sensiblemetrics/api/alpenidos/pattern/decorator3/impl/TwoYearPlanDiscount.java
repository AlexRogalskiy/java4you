package com.sensiblemetrics.api.alpenidos.pattern.decorator3.impl;

import com.sensiblemetrics.api.alpenidos.pattern.decorator3.iface.Discount;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class TwoYearPlanDiscount extends DiscountDecorator {

    public static final BigDecimal NINETY_NINE = new BigDecimal(95);
    public static final BigDecimal ONE_HUNDRED = new BigDecimal(100);

    public TwoYearPlanDiscount(final Discount discount) {
        super(discount);
    }

    @Override
    public BigDecimal apply(final BigDecimal originalPrice) {
        return super.apply(originalPrice).multiply(NINETY_NINE).divide(ONE_HUNDRED, RoundingMode.CEILING);
    }
}
