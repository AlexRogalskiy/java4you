package com.sensiblemetrics.api.alpenidos.pattern.strategy.impl;

import com.sensiblemetrics.api.alpenidos.pattern.strategy.iface.Strategy;
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
