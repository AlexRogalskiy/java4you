package com.sensiblemetrics.api.alpenidos.pattern.strategy4;

import com.sensiblemetrics.api.alpenidos.pattern.strategy4.algorithms.AdditionOperation;
import com.sensiblemetrics.api.alpenidos.pattern.strategy4.context.OperationContext;

public class TestCalculationStrategy {

    public static void main(final String[] args) {
        final OperationContext addContext = new OperationContext(new AdditionOperation());
        final int add = addContext.executeStrategy(10, 20);
        System.out.println("Addition Operation strategy output : " + add);

        // write there for the reamining three.
    }
}
