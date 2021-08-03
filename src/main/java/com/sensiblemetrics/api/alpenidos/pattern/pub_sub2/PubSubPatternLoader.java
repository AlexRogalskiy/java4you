package com.sensiblemetrics.api.alpenidos.pattern.pub_sub2;

import com.sensiblemetrics.api.alpenidos.pattern.pub_sub2.observer.ConcreteObserver;
import com.sensiblemetrics.api.alpenidos.pattern.pub_sub2.subject.ConcreteSubject;

public class PubSubPatternLoader {

    public static void main(final String[] args) {
        final ConcreteSubject s = new ConcreteSubject();

        s.attach(new ConcreteObserver("A", s));
        s.attach(new ConcreteObserver("B", s));
        s.attach(new ConcreteObserver("C", s));

        s.setSubjectState("ABC");
        s.notifyA();
    }
}
