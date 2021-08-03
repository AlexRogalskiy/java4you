package com.sensiblemetrics.api.alpenidos.pattern.interpreter.expression;

import com.sensiblemetrics.api.alpenidos.pattern.interpreter.iface.Expression;
import com.sensiblemetrics.api.alpenidos.pattern.interpreter.model.Context;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
public class From implements Expression {
    private final String table;
    private final Where where;

    public From(final String table) {
        this(table, null);
    }

    @Override
    public List<String> interpret(final Context ctx) {
        ctx.setTable(this.table);
        if (Objects.isNull(this.where)) {
            return ctx.search();
        }
        return this.where.interpret(ctx);
    }
}
