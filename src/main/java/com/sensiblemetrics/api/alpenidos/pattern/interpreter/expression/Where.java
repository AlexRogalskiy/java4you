package com.sensiblemetrics.api.alpenidos.pattern.interpreter.expression;

import com.sensiblemetrics.api.alpenidos.pattern.interpreter.model.Context;
import com.sensiblemetrics.api.alpenidos.pattern.interpreter.iface.Expression;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.function.Predicate;

@RequiredArgsConstructor
public class Where implements Expression {
    private final Predicate<String> filter;

    @Override
    public List<String> interpret(final Context ctx) {
        ctx.setFilter(this.filter);
        return ctx.search();
    }
}
