package com.sensiblemetrics.api.alpenidos.pattern.interpreter4.impl;

import com.sensiblemetrics.api.alpenidos.pattern.interpreter4.iface.Expression;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
public class NumberExpression implements Expression {
    private final String variableName;

    public Integer execute(final Map<String, Integer> context) {
        return context.get(this.variableName);
    }
}
