package com.sensiblemetrics.api.alpenidos.pattern.interpreter5.expression;

import com.sensiblemetrics.api.alpenidos.pattern.interpreter5.management.Context;

public class OrExpression extends AbstractExpressions {

    private final AbstractExpressions first;
    private final AbstractExpressions second;

    public OrExpression(AbstractExpressions first, AbstractExpressions second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean interpret(Context context) throws Exception {
        return this.first.interpret(context) || this.second.interpret(context);
    }
}
