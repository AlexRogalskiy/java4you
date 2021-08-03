package com.sensiblemetrics.api.alpenidos.pattern.rule_engine.impl;

import com.sensiblemetrics.api.alpenidos.pattern.rule_engine.iface.Command;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AddCommand implements Command {
    private final int a;
    private final int b;

    @Override
    public Integer execute() {
        return this.a + this.b;
    }
}
