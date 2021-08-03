package com.sensiblemetrics.api.alpenidos.pattern.facade3.factory;

import com.sensiblemetrics.api.alpenidos.pattern.facade3.iface.Node;
import com.sensiblemetrics.api.alpenidos.pattern.facade3.impl.ExpressionNode;
import com.sensiblemetrics.api.alpenidos.pattern.facade3.impl.OperandNode;

/**
 * Generator, supposed to generate binary code, but in this case acts as a
 * calculator which adds two numbers.
 */
public class Generator {

    public static int generate(final Node expression) throws Exception {
        if (expression instanceof ExpressionNode) {
            final ExpressionNode expressionNode = (ExpressionNode) expression;
            final OperandNode rightOperandNode = (OperandNode) expressionNode.getRight();
            final OperandNode leftOperandNode = (OperandNode) expressionNode.getLeft();
            return (rightOperandNode.getValue() + leftOperandNode.getValue());
        }
        throw new Exception("Error in generator");
    }
}
