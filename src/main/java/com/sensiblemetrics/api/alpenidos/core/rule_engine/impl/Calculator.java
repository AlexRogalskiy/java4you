package com.sensiblemetrics.api.alpenidos.core.rule_engine.impl;

import com.sensiblemetrics.api.alpenidos.core.rule_engine.iface.Command;
import com.sensiblemetrics.api.alpenidos.core.rule_engine.iface.Operation;

public class Calculator {

    public int calculate(int a, int b, final String operator) {
        int result = Integer.MIN_VALUE;

        if ("add".equals(operator)) {
            result = a + b;
        } else if ("multiply".equals(operator)) {
            result = a * b;
        } else if ("divide".equals(operator)) {
            result = a / b;
        } else if ("subtract".equals(operator)) {
            result = a - b;
        } else if ("modulo".equals(operator)) {
            result = a % b;
        }
        return result;
    }

    public int calculateUsingSwitch(int a, int b, final String operator) {
        int result = 0;
        switch (operator) {
            case "add":
                result = a + b;
                break;
            case "multiply":
                result = a * b;
                break;
            case "divide":
                result = a / b;
                break;
            case "subtract":
                result = a - b;
                break;
            case "modulo":
                result = a % b;
                break;
            default:
                result = Integer.MIN_VALUE;
        }
        return result;
    }

    public int calculateUsingSwitch(int a, int b, final Operator operator) {
        int result = 0;
        switch (operator) {
            case ADD:
                result = a + b;
                break;
            case MULTIPLY:
                result = a * b;
                break;
            case DIVIDE:
                result = a / b;
                break;
            case SUBTRACT:
                result = a - b;
                break;
            case MODULO:
                result = a % b;
                break;
            default:
                result = Integer.MIN_VALUE;
        }
        return result;
    }

    public int calculate(int a, int b, final Operator operator) {
        return operator.apply(a, b);
    }

    public int calculateUsingFactory(int a, int b, final String operation) {
        final Operation targetOperation = OperatorFactory.getOperation(operation).orElseThrow(() -> new IllegalArgumentException("Invalid Operator"));
        return targetOperation.apply(a, b);
    }

    public int calculate(final Command command) {
        return command.execute();
    }
}
