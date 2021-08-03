package com.sensiblemetrics.api.alpenidos.pattern.interpreter2.impl;

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
