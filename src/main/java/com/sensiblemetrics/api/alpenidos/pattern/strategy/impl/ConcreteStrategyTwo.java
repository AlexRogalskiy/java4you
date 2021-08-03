package com.sensiblemetrics.api.alpenidos.pattern.strategy.impl;

import com.sensiblemetrics.api.alpenidos.pattern.strategy.iface.Strategy;

public class ConcreteStrategyTwo implements Strategy {
    @Override
    public String doSomething() {
        return "Concrete Strategy Two";
    }
}
