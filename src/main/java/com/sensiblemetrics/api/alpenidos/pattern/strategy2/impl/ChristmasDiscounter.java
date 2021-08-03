package com.sensiblemetrics.api.alpenidos.pattern.strategy2.impl;

import com.sensiblemetrics.api.alpenidos.pattern.strategy2.iface.Discounter;

import java.math.BigDecimal;

public class ChristmasDiscounter implements Discounter {

    @Override
    public BigDecimal apply(BigDecimal amount) {
        return amount.multiply(BigDecimal.valueOf(0.9));
    }
}
