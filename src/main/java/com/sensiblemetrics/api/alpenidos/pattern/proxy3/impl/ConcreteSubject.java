package com.sensiblemetrics.api.alpenidos.pattern.proxy3.impl;

import com.sensiblemetrics.api.alpenidos.pattern.proxy3.iface.ISubject;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcreteSubject implements ISubject {

    @Override
    public void action() {
        log.info("ConcreteSubject action()");
    }
}
