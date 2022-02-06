package com.sensiblemetrics.api.alpenidos.pattern.price.impl;

import com.sensiblemetrics.api.alpenidos.pattern.price.model.Item;
import com.sensiblemetrics.api.alpenidos.pattern.price.interfaces.DeliveryPriceCalculator;

import java.math.BigDecimal;

public class PremiumDeliveryPriceCalculator implements DeliveryPriceCalculator {
    @Override
    public BigDecimal priceFor(final Item item) {
        return item.price().multiply(new BigDecimal("0.015")).add(new BigDecimal("1.0"));
    }
}
