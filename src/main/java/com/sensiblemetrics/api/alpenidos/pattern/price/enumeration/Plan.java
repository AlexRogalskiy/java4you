package com.sensiblemetrics.api.alpenidos.pattern.price.enumeration;

import com.sensiblemetrics.api.alpenidos.pattern.price.model.Item;

import java.math.BigDecimal;
import java.util.function.Function;

public enum Plan {
    BASIC(deliveryPriceWithPercentageSurplus("0.025")),
    PREMIUM(deliveryPriceWithPercentageSurplus("0.015")),
    BUSINESS(deliveryPriceWithPercentageSurplus("0.0"));

    public final Function<Item, BigDecimal> deliveryPrice;

    Plan(Function<Item, BigDecimal> deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    private static Function<Item, BigDecimal> deliveryPriceWithPercentageSurplus(final String percentageSurplus) {
        return item -> item.price().multiply(new BigDecimal(percentageSurplus)).add(new BigDecimal("1.0"));
    }
}
