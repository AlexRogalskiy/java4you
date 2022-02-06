package com.sensiblemetrics.api.alpenidos.pattern.price.impl;

import com.sensiblemetrics.api.alpenidos.pattern.price.model.Item;
import com.sensiblemetrics.api.alpenidos.pattern.price.interfaces.DeliveryPriceCalculator;

import java.math.BigDecimal;

public class BusinessDeliveryPriceCalculator implements DeliveryPriceCalculator {
    @Override
    public BigDecimal priceFor(final Item item) {
        return new BigDecimal("1.0");
    }
}
