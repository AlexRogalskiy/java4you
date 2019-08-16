package com.sensiblemetrics.api.alpenidos.core.pub_sub2.observer;

import com.sensiblemetrics.api.alpenidos.core.pub_sub2.subject.ConcreteSubject;

public class ConcreteObserver extends Observer {
    private String name;
    private String observerState;
    private ConcreteSubject subject;

    /**
     * @param name
     * @param subject
     */
    public ConcreteObserver(final String name, final ConcreteSubject subject) {
        this.name = name;
        this.subject = subject;
    }

    @Override
    public void update() {
        this.observerState = subject.getSubjectState();
        System.out.format("观察者%s的新状态是%s", name, observerState);
    }

    /**
     * @return the subject
     */
    public ConcreteSubject getSubject() {
        return this.subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(ConcreteSubject subject) {
        this.subject = subject;
    }
}
