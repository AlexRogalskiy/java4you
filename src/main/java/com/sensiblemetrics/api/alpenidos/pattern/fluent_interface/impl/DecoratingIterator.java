package com.sensiblemetrics.api.alpenidos.pattern.fluent_interface.impl;

import lombok.RequiredArgsConstructor;

import java.util.Iterator;

/**
 * This class is used to realize LazyFluentIterables. It decorates a given iterator. Does not
 * support consecutive hasNext() calls.
 *
 * @param <E> Iterable Collection of Elements of Type E
 */
@RequiredArgsConstructor
public abstract class DecoratingIterator<E> implements Iterator<E> {
    protected final Iterator<E> fromIterator;

    private E next;

    /**
     * Precomputes and saves the next element of the Iterable. null is considered as end of data.
     *
     * @return true if a next element is available
     */
    @Override
    public final boolean hasNext() {
        this.next = this.computeNext();
        return this.next != null;
    }

    /**
     * Returns the next element of the Iterable.
     *
     * @return the next element of the Iterable, or null if not present.
     */
    @Override
    public final E next() {
        if (this.next == null) {
            return this.fromIterator.next();
        } else {
            final E result = this.next;
            this.next = null;
            return result;
        }
    }

    /**
     * Computes the next object of the Iterable. Can be implemented to realize custom behaviour for an
     * iteration process. null is considered as end of data.
     *
     * @return the next element of the Iterable.
     */
    public abstract E computeNext();
}
