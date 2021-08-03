package com.sensiblemetrics.api.alpenidos.pattern.adaptor.impl;

import com.sensiblemetrics.api.alpenidos.pattern.adaptor.adaptee.Adaptee;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Adapter implements ITarget {

    private Adaptee adaptee = new Adaptee();

    @Override
    public void request() {
        log.info("Adapter.request");
        this.adaptee.onRequest();
    }
}
