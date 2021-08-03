package com.sensiblemetrics.api.alpenidos.pattern.rule_engine.impl;

import com.sensiblemetrics.api.alpenidos.pattern.rule_engine.iface.Operation;

public class Subtraction implements Operation {

    @Override
    public int apply(int a, int b) {
        return a - b;
    }
}
