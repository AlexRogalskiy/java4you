package com.sensiblemetrics.api.alpenidos.core.strategy4.algorithms;

public class MultiplicationOperation implements IBaseOperation {

    @Override
    public int doOperation(final int value1, final int value2) {
        return value1 * value2;
    }
}
