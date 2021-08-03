package com.sensiblemetrics.api.alpenidos.pattern.rule_engine.iface;

import com.sensiblemetrics.api.alpenidos.pattern.rule_engine.impl.Expression;
import com.sensiblemetrics.api.alpenidos.pattern.rule_engine.impl.Result;

public interface Rule {

    boolean evaluate(final Expression expression);

    Result getResult();
}
