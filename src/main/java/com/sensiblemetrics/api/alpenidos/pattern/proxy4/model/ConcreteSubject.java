package com.sensiblemetrics.api.alpenidos.pattern.proxy4.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcreteSubject implements ISubject {

    @Override
    public void action() {
        log.info("ConcreteSubject action()");
    }
}
