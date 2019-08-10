package com.sensiblemetrics.api.alpenidos.core.proxy4.decorator;

import com.sensiblemetrics.api.alpenidos.core.proxy4.model.ISubject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class SubjectPostDecorator implements ISubject {
    private final ISubject subject;

    @Override
    public void action() {
        this.subject.action();
        this.postAction();
    }

    private void postAction() {
        log.info("SubjectPostDecorator.preAction()");
    }
}
