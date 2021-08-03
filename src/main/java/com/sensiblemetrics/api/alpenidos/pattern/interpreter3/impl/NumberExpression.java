package com.sensiblemetrics.api.alpenidos.pattern.interpreter3.impl;

import com.sensiblemetrics.api.alpenidos.pattern.interpreter3.iface.Expression;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
public class NumberExpression implements Expression {
    private final Character chineseNumber;

    public int interpret(final Map<String, Map<Character, Integer>> context) {
        return context.get("numbers").get(chineseNumber);
    }

    public int getPriority(final Map<String, Map<Character, Integer>> context) {
        return 1;
    }
}
