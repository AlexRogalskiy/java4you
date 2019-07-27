package com.sensiblemetrics.api.alpenidos.core.strategy.impl;

import com.sensiblemetrics.api.alpenidos.core.strategy.iface.Strategy;

public class ConcreteStrategyTwo implements Strategy {
    @Override
    public String doSomething() {
        return "Concrete Strategy Two";
    }
}
