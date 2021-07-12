package com.sensiblemetrics.api.alpenidos.core.interpreter5.management;

import com.sensiblemetrics.api.alpenidos.core.interpreter5.expression.VariableExpression;
import java.util.HashMap;
import java.util.Map;

public class Context {

    private final Map<String, Boolean> poolVariables = new HashMap<>();

    public boolean lookUp(String name) throws Exception {
        if (!poolVariables.containsKey(name)) {
            throw new Exception("No exist variable: name");
        }

        return this.poolVariables.get(name);
    }

    public void assign(VariableExpression variable, boolean value) {
        this.poolVariables.put(variable.getName(), value);
    }
}
