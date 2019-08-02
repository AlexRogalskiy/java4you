package com.sensiblemetrics.api.alpenidos.core.observer;

import com.sensiblemetrics.api.alpenidos.core.observer.iface.Observer;
import com.sensiblemetrics.api.alpenidos.core.observer.impl.ConcreteObserver;
import com.sensiblemetrics.api.alpenidos.core.observer.impl.ConcreteSubject;
import com.sensiblemetrics.api.alpenidos.core.observer.model.Event;
import com.sensiblemetrics.api.alpenidos.core.observer.model.Subject;

public class ObserverPatternLoader {

    public static void main(final String[] args) {
        final Subject concreteSubject = new ConcreteSubject();

        final Observer concreteObserverOne = new ConcreteObserver();
        final Observer concreteObserverTwo = new ConcreteObserver();
        final Observer concreteObserverThree = new ConcreteObserver();

        concreteSubject.attach(0, concreteObserverOne);
        concreteSubject.attach(0, concreteObserverTwo);
        concreteSubject.attach(1, concreteObserverOne);
        concreteSubject.attach(1, concreteObserverThree);
        concreteSubject.attach(2, concreteObserverTwo);
        concreteSubject.attach(3, concreteObserverThree);

        final Event mainEvent = new Event(0, "AdapterPattern2Loader event: ");
        final Event firstEvent = new Event(1, "First event: ");
        final Event secondEvent = new Event(2, "Second event: ");
        final Event thirdEvent = new Event(3, "Third event: ");

        concreteSubject.notifyObserver(0, mainEvent);
        concreteSubject.notifyObserver(1, firstEvent);
        concreteSubject.notifyObserver(2, secondEvent);
        concreteSubject.notifyObserver(3, thirdEvent);
    }
}
