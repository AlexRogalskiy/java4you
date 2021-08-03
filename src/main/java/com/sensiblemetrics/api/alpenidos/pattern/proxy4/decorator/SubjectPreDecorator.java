package com.sensiblemetrics.api.alpenidos.pattern.proxy4.decorator;

import com.sensiblemetrics.api.alpenidos.pattern.proxy4.model.ISubject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class SubjectPreDecorator implements ISubject {
    private final ISubject subject;

    @Override
    public void action() {
        this.preAction();
        this.subject.action();
    }

    private void preAction() {
        log.info("SubjectPreDecorator.preAction()");
    }
}
