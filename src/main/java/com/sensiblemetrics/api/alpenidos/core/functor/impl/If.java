package com.sensiblemetrics.api.alpenidos.core.functor.impl;

import com.sensiblemetrics.api.alpenidos.core.functor.iface.Conditional;
import com.sensiblemetrics.api.alpenidos.core.functor.iface.Task;

import java.util.LinkedHashMap;
import java.util.Map;

public class If {
    private Map<Conditional, Task> conditionalFlow;
    private final Conditional noneMatch = () -> true;

    public If(final Conditional condition, final Task task) {
        this.conditionalFlow = new LinkedHashMap<>();
        this.put(condition, task);
    }

    public If elseIf(final Conditional condition, final Task task) {
        put(condition, task);
        return this;
    }

    public If orElse(final Task task) {
        this.put(this.noneMatch, task);
        return this;
    }

    public void doChainedTest() {
        final Conditional conditional = this.conditionalFlow.keySet().stream().filter(c -> c.condition()).findFirst().get();
        this.conditionalFlow.get(conditional).execute();
    }

    private void put(final Conditional condition, final Task task) {
        this.conditionalFlow.put(condition, task);
    }
}
