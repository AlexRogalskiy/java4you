package com.sensiblemetrics.api.alpenidos.core.facade3.factory;

import com.sensiblemetrics.api.alpenidos.core.facade3.iface.Node;
import com.sensiblemetrics.api.alpenidos.core.facade3.impl.ExpressionNode;
import com.sensiblemetrics.api.alpenidos.core.facade3.impl.OperandNode;

import java.util.List;
import java.util.Stack;

/**
 * Parser parses simple expression which adds two numbers, for example: 1 + 2
 * Note: due to scope error handling is not implemented.
 */
public class Parser {
    private final Stack<String> expressionStack = new Stack<>();
    private final Stack<String> operandStack = new Stack<>();

    public Node parse(final List<String> tokens) {
        for (final String token : tokens) {
            if (this.isTokenExpression(token)) {
                this.expressionStack.push(token);
            } else if (this.isTokenOperand(token)) {
                this.operandStack.push(token);
            }
        }
        final ExpressionNode expressionNode = new ExpressionNode();
        // create Abstract Syntax Tree
        while (!this.expressionStack.empty()) {
            final String expression = this.expressionStack.pop();
            expressionNode.setOperator(expression.charAt(0));

            final String rightOperand = this.operandStack.pop();
            final OperandNode rightOperandNode = new OperandNode();
            rightOperandNode.setValue(Integer.parseInt(rightOperand));

            final String leftOperand = this.operandStack.pop();
            final OperandNode leftOperandNode = new OperandNode();
            leftOperandNode.setValue(Integer.parseInt(leftOperand));

            expressionNode.setRight(rightOperandNode);
            expressionNode.setLeft(leftOperandNode);
        }
        return expressionNode;
    }

    private boolean isTokenExpression(final String token) {
        return token.equals("+");
    }

    private boolean isTokenOperand(final String token) {
        for (final char c : token.toCharArray()) {
            if (!Character.isDigit(c))
                return false;
        }
        return true;
    }
}
