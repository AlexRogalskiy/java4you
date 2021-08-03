package com.sensiblemetrics.api.alpenidos.pattern.adaptor.impl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcreteTarget implements ITarget {

    @Override
    public void request() {
        log.info("ConcreteTarget.request()");
    }
}
