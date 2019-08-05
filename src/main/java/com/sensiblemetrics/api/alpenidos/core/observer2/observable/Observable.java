package com.sensiblemetrics.api.alpenidos.core.observer2.observable;

import com.sensiblemetrics.api.alpenidos.core.observer2.iface.Observer;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Generic observer inspired by Java Generics and Collection by {@literal Naftalin & Wadler}
 *
 * @param <S> Subject
 * @param <O> Observer
 * @param <A> Argument type
 */
public abstract class Observable<S extends Observable<S, O, A>, O extends Observer<S, O, A>, A> {
    protected List<O> observers;

    public Observable() {
        this.observers = new CopyOnWriteArrayList<>();
    }

    public void addObserver(final O observer) {
        this.observers.add(observer);
    }

    public void removeObserver(final O observer) {
        this.observers.remove(observer);
    }

    /**
     * Notify observers
     */
    @SuppressWarnings("unchecked")
    public void notifyObservers(final A argument) {
        this.observers.forEach(o -> o.update((S) this, argument));
    }
}
