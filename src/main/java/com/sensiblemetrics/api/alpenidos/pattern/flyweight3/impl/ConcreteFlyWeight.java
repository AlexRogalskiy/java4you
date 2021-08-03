package com.sensiblemetrics.api.alpenidos.pattern.flyweight3.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class ConcreteFlyWeight implements FlyWeight {
    private final String name;

    @Override
    public void action(final String externalState) {
        log.info("name = {}, outerState = {}", this.name, externalState);
    }
}
