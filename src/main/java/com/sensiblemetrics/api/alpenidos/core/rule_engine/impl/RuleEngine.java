package com.sensiblemetrics.api.alpenidos.core.rule_engine.impl;

import com.sensiblemetrics.api.alpenidos.core.rule_engine.iface.Rule;

import java.util.ArrayList;
import java.util.List;

public class RuleEngine {
    private static final List<Rule> rules = new ArrayList<>();

    static {
        rules.add(new AddRule());
    }

    public Result process(final Expression expression) {
        final Rule rule = rules
            .stream()
            .filter(r -> r.evaluate(expression))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Expression does not matches any Rule"));
        return rule.getResult();
    }
}
