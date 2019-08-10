package com.sensiblemetrics.api.alpenidos.core.proxy4.impl;

import com.sensiblemetrics.api.alpenidos.core.proxy4.model.ConcreteSubject;
import com.sensiblemetrics.api.alpenidos.core.proxy4.model.ISubject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
@RequiredArgsConstructor
public class ProxySubject implements ISubject {
    private final ISubject subject;

    public ProxySubject() {
        this.subject = new ConcreteSubject();
    }

    @Override
    public void action() {
        this.preAction();
        if ((new Random()).nextBoolean()) {
            this.subject.action();
        } else {
            log.info("Permission denied");
        }
        this.postAction();
    }

    private void preAction() {
        log.info("ProxySubject.preAction()");
    }

    private void postAction() {
        log.info("ProxySubject.postAction()");
    }
}
