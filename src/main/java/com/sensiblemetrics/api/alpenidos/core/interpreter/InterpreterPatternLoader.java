package com.sensiblemetrics.api.alpenidos.core.interpreter;

import com.sensiblemetrics.api.alpenidos.core.interpreter.iface.Expression;
import com.sensiblemetrics.api.alpenidos.core.interpreter.expression.From;
import com.sensiblemetrics.api.alpenidos.core.interpreter.expression.Select;
import com.sensiblemetrics.api.alpenidos.core.interpreter.expression.Where;
import com.sensiblemetrics.api.alpenidos.core.interpreter.model.Context;

import java.util.List;

public class InterpreterPatternLoader {

    public static void main(final String[] args) {
        final Context ctx = new Context();

        final Expression query = new Select("name", new From("people"));
        final List<String> result = query.interpret(ctx);
        System.out.println(result);

        final Expression query2 = new Select("*", new From("people"));
        final List<String> result2 = query2.interpret(ctx);
        System.out.println(result2);

        final Expression query3 = new Select("name", new From("people", new Where(name -> name.toLowerCase().startsWith("d"))));
        final List<String> result3 = query3.interpret(ctx);
        System.out.println(result3);
    }
}
