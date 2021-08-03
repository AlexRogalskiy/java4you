package com.sensiblemetrics.api.alpenidos.pattern.interpreter2.impl;

import lombok.RequiredArgsConstructor;

/**
 * NumberExpression
 */
@RequiredArgsConstructor
public class NumberExpression extends Expression {
    private final int number;

    public NumberExpression(String s) {
        this(Integer.parseInt(s));
    }

    @Override
    public int interpret() {
        return this.number;
    }

    @Override
    public String toString() {
        return "number";
    }
}
