package com.sensiblemetrics.api.alpenidos.core.interpreter2.impl;

import com.sensiblemetrics.api.alpenidos.core.interpreter2.impl.Expression;
import lombok.RequiredArgsConstructor;

/**
 * MinusExpression
 */
@RequiredArgsConstructor
public class MinusExpression extends Expression {
    private final Expression leftExpression;
    private final Expression rightExpression;

    @Override
    public int interpret() {
        return this.leftExpression.interpret() - this.rightExpression.interpret();
    }

    @Override
    public String toString() {
        return "-";
    }
}
