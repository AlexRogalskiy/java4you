package com.sensiblemetrics.api.alpenidos.core.lambda.converter;

import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleUnaryOperator;

/**
 * Created by mtumilowicz on 2018-11-26.
 */
@FunctionalInterface
interface CurrableDoubleBinaryOperator extends DoubleBinaryOperator {

    default DoubleUnaryOperator rate(double u) {
        return t -> this.applyAsDouble(t, u);
    }
}
