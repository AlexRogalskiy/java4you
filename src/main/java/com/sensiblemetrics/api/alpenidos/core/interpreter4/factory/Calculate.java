package com.sensiblemetrics.api.alpenidos.core.interpreter4.factory;

import com.sensiblemetrics.api.alpenidos.core.interpreter4.enums.Operator;
import com.sensiblemetrics.api.alpenidos.core.interpreter4.iface.Expression;
import com.sensiblemetrics.api.alpenidos.core.interpreter4.impl.NumberExpression;
import com.sensiblemetrics.api.alpenidos.core.interpreter4.impl.OperatorExpression;
import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.Stack;

@RequiredArgsConstructor
public class Calculate {
    private final Map<String, Integer> context;

    public Integer calculate() {
        final Stack<Expression> stack = new Stack<>();
        Expression left;

        stack.push(new NumberExpression("a"));
        left = stack.pop();
        stack.push(new OperatorExpression(Operator.add, left, new NumberExpression("b")));
        left = stack.pop();
        stack.push(new OperatorExpression(Operator.sub, left, new NumberExpression("c")));

        return stack.pop().execute(context);
    }
}
