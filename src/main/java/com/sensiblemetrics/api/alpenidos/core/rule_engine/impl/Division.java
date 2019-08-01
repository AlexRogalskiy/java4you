package com.sensiblemetrics.api.alpenidos.core.rule_engine.impl;

import com.sensiblemetrics.api.alpenidos.core.rule_engine.iface.Operation;

public class Division implements Operation {

    @Override
    public int apply(int a, int b) {
        return a / b;
    }
}
