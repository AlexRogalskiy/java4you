
package com.sensiblemetrics.api.alpenidos.core.interpreter5.expression;

import com.sensiblemetrics.api.alpenidos.core.interpreter5.management.Context;

public class AndExpression extends AbstractExpressions {

    private final AbstractExpressions first;
    private final AbstractExpressions second;

    public AndExpression(AbstractExpressions first, AbstractExpressions second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean interpret(Context context) throws Exception {
        return this.first.interpret(context) && this.second.interpret(context);
    }
}
