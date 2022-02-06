package com.sensiblemetrics.api.alpenidos.pattern.price.interfaces;

import com.sensiblemetrics.api.alpenidos.pattern.price.model.Item;

import java.math.BigDecimal;

@FunctionalInterface
public interface DeliveryPriceCalculator {
    BigDecimal priceFor(final Item item);
}
