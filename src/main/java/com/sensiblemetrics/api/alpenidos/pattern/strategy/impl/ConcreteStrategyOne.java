package com.sensiblemetrics.api.alpenidos.pattern.strategy.impl;

import com.sensiblemetrics.api.alpenidos.pattern.strategy.iface.Strategy;

public class ConcreteStrategyOne implements Strategy {
    @Override
    public String doSomething() {
        return "ConcreteStrategyOne";
    }
}
