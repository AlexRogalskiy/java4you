package com.sensiblemetrics.api.alpenidos.core.interpreter3.impl;

import com.sensiblemetrics.api.alpenidos.core.interpreter3.iface.Expression;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class UnitExpression implements Expression {
    private final Character unit;
    private final List<Expression> lefts;

    public int interpret(final Map<String, Map<Character, Integer>> context) {
        int base = 0;
        for (final Expression left : this.lefts)
            base += left.interpret(context);

        return base * context.get("units").get(unit);
    }

    public int getPriority(final Map<String, Map<Character, Integer>> context) {
        return context.get("units").get(this.unit);
    }
}
