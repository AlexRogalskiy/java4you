package com.sensiblemetrics.api.alpenidos.core.proxy4.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcreteSubject implements ISubject {

    @Override
    public void action() {
        log.info("ConcreteSubject action()");
    }
}
