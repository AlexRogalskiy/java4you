package com.sensiblemetrics.api.alpenidos.core.strategy2.impl;

import com.sensiblemetrics.api.alpenidos.core.strategy2.iface.Discounter;

import java.math.BigDecimal;

public class EasterDiscounter implements Discounter {

    @Override
    public BigDecimal apply(final BigDecimal amount) {
        return amount.multiply(BigDecimal.valueOf(0.5));
    }
}
