package com.sensiblemetrics.api.alpenidos.core.interpreter2;

import com.sensiblemetrics.api.alpenidos.core.interpreter2.impl.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

/**
 * The Interpreter pattern is a design pattern that specifies how to evaluate sentences in a
 * language. The basic idea is to have a class for each symbol (terminal or nonterminal) in a
 * specialized computer language. The syntax tree of a sentence in the language is an instance of
 * the composite pattern and is used to evaluate (interpret) the sentence for a client.
 * <p>
 * In this example we use the Interpreter pattern to break sentences into expressions (
 * {@link Expression}) that can be evaluated and as a whole form the result.
 */
@Slf4j
public class InterpreterPatternLoader {

    /**
     * Program entry point.
     * <p>
     * Expressions can be evaluated using prefix, infix or postfix notations This sample uses postfix,
     * where operator comes after the operands
     *
     * @param args command line args
     */
    public static void main(final String[] args) {
        final String tokenString = "4 3 2 - 1 + *";
        final Stack<Expression> stack = new Stack<>();

        final String[] tokenList = tokenString.split(" ");
        for (final String s : tokenList) {
            if (isOperator(s)) {
                final Expression rightExpression = stack.pop();
                final Expression leftExpression = stack.pop();
                log.info("popped from stack left: {} right: {}", leftExpression.interpret(), rightExpression.interpret());

                final Expression operator = getOperatorInstance(s, leftExpression, rightExpression);
                log.info("operator: {}", operator);

                int result = operator.interpret();
                final NumberExpression resultExpression = new NumberExpression(result);
                stack.push(resultExpression);
                log.info("push result to stack: {}", resultExpression.interpret());
            } else {
                final Expression i = new NumberExpression(s);
                stack.push(i);
                log.info("push to stack: {}", i.interpret());
            }
        }
        log.info("result: {}", stack.pop().interpret());
    }

    public static boolean isOperator(final String s) {
        return s.equals("+") || s.equals("-") || s.equals("*");
    }

    /**
     * Get expression for string
     */
    public static Expression getOperatorInstance(final String s, final Expression left, final Expression right) {
        switch (s) {
            case "+":
                return new PlusExpression(left, right);
            case "-":
                return new MinusExpression(left, right);
            case "*":
                return new MultiplyExpression(left, right);
            default:
                return new MultiplyExpression(left, right);
        }
    }
}
