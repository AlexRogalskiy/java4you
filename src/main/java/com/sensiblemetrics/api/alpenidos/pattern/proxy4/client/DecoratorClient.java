package com.sensiblemetrics.api.alpenidos.pattern.proxy4.client;

import com.sensiblemetrics.api.alpenidos.pattern.proxy4.decorator.SubjectPostDecorator;
import com.sensiblemetrics.api.alpenidos.pattern.proxy4.decorator.SubjectPreDecorator;
import com.sensiblemetrics.api.alpenidos.pattern.proxy4.model.ConcreteSubject;
import com.sensiblemetrics.api.alpenidos.pattern.proxy4.model.ISubject;

public class DecoratorClient {

    public static void main(final String[] args) {
        final ISubject subject = new ConcreteSubject();
        final ISubject preDecorator = new SubjectPreDecorator(subject);
        final ISubject postDecorator = new SubjectPostDecorator(preDecorator);
        postDecorator.action();
    }
}
