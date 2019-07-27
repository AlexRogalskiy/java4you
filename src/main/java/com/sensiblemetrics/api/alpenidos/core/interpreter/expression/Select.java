package com.sensiblemetrics.api.alpenidos.core.interpreter.expression;

import com.sensiblemetrics.api.alpenidos.core.interpreter.model.Context;
import com.sensiblemetrics.api.alpenidos.core.interpreter.iface.Expression;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class Select implements Expression {
    private final String column;
    private final From from;

    @Override
    public List<String> interpret(final Context ctx) {
        ctx.setColumn(this.column);
        return this.from.interpret(ctx);
    }
}
