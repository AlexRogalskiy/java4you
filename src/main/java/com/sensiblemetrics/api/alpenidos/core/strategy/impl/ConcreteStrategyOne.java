package com.sensiblemetrics.api.alpenidos.core.strategy.impl;

import com.sensiblemetrics.api.alpenidos.core.strategy.iface.Strategy;

public class ConcreteStrategyOne implements Strategy {
    @Override
    public String doSomething() {
        return "ConcreteStrategyOne";
    }
}
