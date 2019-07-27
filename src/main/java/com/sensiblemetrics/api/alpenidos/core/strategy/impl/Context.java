package com.sensiblemetrics.api.alpenidos.core.strategy.impl;

import com.sensiblemetrics.api.alpenidos.core.strategy.iface.Strategy;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Context {

    private Strategy strategy;

    public void executeStrategy() {
        System.out.println(this.strategy.doSomething());
    }
}
