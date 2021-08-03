package com.sensiblemetrics.api.alpenidos.pattern.lambda.decorator2;

import java.util.function.DoubleUnaryOperator;

public class DefaultSalaryCalculator implements DoubleUnaryOperator {

    @Override
    public double applyAsDouble(double grossAnnual) {
        return grossAnnual / 12;
    }
}
