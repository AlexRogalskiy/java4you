package com.sensiblemetrics.api.alpenidos.core.interpreter4.iface;

import java.util.Map;

public interface Expression {

    Integer execute(final Map<String, Integer> context);
}
