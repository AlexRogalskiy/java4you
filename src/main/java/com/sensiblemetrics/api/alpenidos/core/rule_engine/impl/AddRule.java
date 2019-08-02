package com.sensiblemetrics.api.alpenidos.core.rule_engine.impl;

import com.sensiblemetrics.api.alpenidos.core.rule_engine.iface.Rule;

public class AddRule implements Rule {

    private int result;

    @Override
    public boolean evaluate(final Expression expression) {
        boolean evalResult = false;
        if (expression.getOperator() == Operator.ADD) {
            this.result = expression.getX() + expression.getY();
            evalResult = true;
        }
        return evalResult;
    }

    @Override
    public Result getResult() {
        return new Result(this.result);
    }
}

/*
@ObserverPatternLoader
public void whenNumbersGivenToRuleEngine_thenReturnCorrectResult() {
    Expression expression = new Expression(5, 5, Operator.ADD);
    RuleEngine engine = new RuleEngine();
    Result result = engine.process(expression);

    assertNotNull(result);
    assertEquals(10, result.getValue());
}
 */
