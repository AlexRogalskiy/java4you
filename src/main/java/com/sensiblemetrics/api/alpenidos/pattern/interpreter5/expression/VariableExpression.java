package com.sensiblemetrics.api.alpenidos.pattern.interpreter5.expression;

import com.sensiblemetrics.api.alpenidos.pattern.interpreter5.management.Context;

public class VariableExpression extends AbstractExpressions {

    private final String name;

    public VariableExpression(String name) {
        this.name = name;
    }

    @Override
    public boolean interpret(Context context) throws Exception {
        return context.lookUp(this.name);
    }

    public String getName() {
        return this.name;
    }
}
