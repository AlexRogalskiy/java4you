package com.sensiblemetrics.api.alpenidos.core.interpreter4.impl;

import com.sensiblemetrics.api.alpenidos.core.interpreter4.enums.Operator;
import com.sensiblemetrics.api.alpenidos.core.interpreter4.iface.Expression;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
public class OperatorExpression implements Expression {
    private final Operator operator;
    private final Expression left;
    private final Expression right;

    public Integer execute(final Map<String, Integer> context) {
        Integer result;
        switch (this.operator) {
            case add:
                result = this.left.execute(context) + this.right.execute(context);
                break;
            case sub:
                result = this.left.execute(context) - this.right.execute(context);
                break;
            case mul:
                result = this.left.execute(context) * this.right.execute(context);
                break;
            case div:
                result = this.left.execute(context) / this.right.execute(context);
                break;
            default:
                result = 0;
        }
        return result;
    }
}
