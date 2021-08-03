package com.sensiblemetrics.api.alpenidos.pattern.decorator3.iface;

import java.math.BigDecimal;

public interface Discount {

    BigDecimal apply(final BigDecimal originalPrice);
}
