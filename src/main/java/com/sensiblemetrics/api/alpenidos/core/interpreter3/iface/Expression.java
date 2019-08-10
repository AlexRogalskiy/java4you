package com.sensiblemetrics.api.alpenidos.core.interpreter3.iface;

import java.util.Map;

public interface Expression {

    int interpret(final Map<String, Map<Character, Integer>> context);

    int getPriority(final Map<String, Map<Character, Integer>> context);
}
