package com.sensiblemetrics.api.alpenidos.core.observer2.iface;

import com.sensiblemetrics.api.alpenidos.core.observer2.observable.Observable;

/**
 * Observer
 *
 * @param <S> Observable
 * @param <O> Observer
 * @param <A> Action
 */
public interface Observer<S extends Observable<S, O, A>, O extends Observer<S, O, A>, A> {

    void update(final S subject, final A argument);
}
