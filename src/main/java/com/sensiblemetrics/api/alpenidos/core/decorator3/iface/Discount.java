package com.sensiblemetrics.api.alpenidos.core.decorator3.iface;

import java.math.BigDecimal;

public interface Discount {

    BigDecimal apply(final BigDecimal originalPrice);
}
