package com.sensiblemetrics.api.alpenidos.pattern.strategy4.context;

import com.sensiblemetrics.api.alpenidos.pattern.strategy4.algorithms.IBaseOperation;

public class OperationContext {

    private IBaseOperation iBaseOperation;

    public OperationContext(final IBaseOperation iBaseOperation) {
        this.iBaseOperation = iBaseOperation;
    }

    public int executeStrategy(final int value1, final int value2) {
        return this.iBaseOperation.doOperation(value1, value2);
    }
}
