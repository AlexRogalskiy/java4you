package com.sensiblemetrics.api.alpenidos.pattern.fluent_interface.impl;

import com.sensiblemetrics.api.alpenidos.pattern.fluent_interface.iface.FluentIterable;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * This is a lazy implementation of the FluentIterable interface. It evaluates all chained
 * operations when a terminating operation is applied.
 *
 * @param <E> the type of the objects the iteration is about
 */
@RequiredArgsConstructor
public class LazyFluentIterable<E> implements FluentIterable<E> {
    private final Iterable<E> iterable;

    /**
     * This constructor can be used to implement anonymous subclasses of the LazyFluentIterable.
     */
    protected LazyFluentIterable() {
        this.iterable = this;
    }

    /**
     * Filters the contents of Iterable using the given predicate, leaving only the ones which satisfy
     * the predicate.
     *
     * @param predicate the condition to test with for the filtering. If the test is negative, the
     *                  tested object is removed by the iterator.
     * @return a new FluentIterable object that decorates the source iterable
     */
    @Override
    public FluentIterable<E> filter(final Predicate<? super E> predicate) {
        return new LazyFluentIterable<E>() {
            @Override
            public Iterator<E> iterator() {
                return new DecoratingIterator<E>(iterable.iterator()) {
                    @Override
                    public E computeNext() {
                        while (this.fromIterator.hasNext()) {
                            final E candidate = fromIterator.next();
                            if (predicate.test(candidate)) {
                                return candidate;
                            }
                        }
                        return null;
                    }
                };
            }
        };
    }

    /**
     * Can be used to collect objects from the iteration. Is a terminating operation.
     *
     * @return an Optional containing the first object of this Iterable
     */
    @Override
    public Optional<E> first() {
        final Iterator<E> resultIterator = this.first(1).iterator();
        return resultIterator.hasNext() ? Optional.of(resultIterator.next()) : Optional.empty();
    }

    /**
     * Can be used to collect objects from the iteration.
     *
     * @param count defines the number of objects to return
     * @return the same FluentIterable with a collection decimated to a maximum of 'count' first
     * objects.
     */
    @Override
    public FluentIterable<E> first(int count) {
        return new LazyFluentIterable<E>() {
            @Override
            public Iterator<E> iterator() {
                return new DecoratingIterator<E>(iterable.iterator()) {
                    int currentIndex;

                    @Override
                    public E computeNext() {
                        if (this.currentIndex < count && this.fromIterator.hasNext()) {
                            final E candidate = this.fromIterator.next();
                            this.currentIndex++;
                            return candidate;
                        }
                        return null;
                    }
                };
            }
        };
    }

    /**
     * Can be used to collect objects from the iteration. Is a terminating operation.
     *
     * @return an Optional containing the last object of this Iterable
     */
    @Override
    public Optional<E> last() {
        Iterator<E> resultIterator = this.last(1).iterator();
        return resultIterator.hasNext() ? Optional.of(resultIterator.next()) : Optional.empty();
    }

    /**
     * Can be used to collect objects from the Iterable. Is a terminating operation. This operation is
     * memory intensive, because the contents of this Iterable are collected into a List, when the
     * next object is requested.
     *
     * @param count defines the number of objects to return
     * @return the same FluentIterable with a collection decimated to a maximum of 'count' last
     * objects
     */
    @Override
    public FluentIterable<E> last(int count) {
        return new LazyFluentIterable<E>() {
            @Override
            public Iterator<E> iterator() {
                return new DecoratingIterator<E>(iterable.iterator()) {
                    private int stopIndex;
                    private int totalElementsCount;
                    private List<E> list;
                    private int currentIndex;

                    @Override
                    public E computeNext() {
                        this.initialize();

                        E candidate = null;
                        while (this.currentIndex < this.stopIndex && this.fromIterator.hasNext()) {
                            this.currentIndex++;
                            this.fromIterator.next();
                        }
                        if (this.currentIndex >= this.stopIndex && this.fromIterator.hasNext()) {
                            candidate = fromIterator.next();
                        }
                        return candidate;
                    }

                    private void initialize() {
                        if (this.list == null) {
                            this.list = new ArrayList<>();
                            final Iterator<E> newIterator = iterable.iterator();
                            while (newIterator.hasNext()) {
                                this.list.add(newIterator.next());
                            }
                            this.totalElementsCount = list.size();
                            this.stopIndex = this.totalElementsCount - count;
                        }
                    }
                };
            }
        };
    }

    /**
     * Transforms this FluentIterable into a new one containing objects of the type T.
     *
     * @param function a function that transforms an instance of E into an instance of T
     * @param <T>      the target type of the transformation
     * @return a new FluentIterable of the new type
     */
    @Override
    public <T> FluentIterable<T> map(final Function<? super E, T> function) {
        return new LazyFluentIterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return new DecoratingIterator<T>(null) {
                    final Iterator<E> oldTypeIterator = iterable.iterator();

                    @Override
                    public T computeNext() {
                        if (this.oldTypeIterator.hasNext()) {
                            final E candidate = this.oldTypeIterator.next();
                            return function.apply(candidate);
                        }
                        return null;
                    }
                };
            }
        };
    }

    /**
     * Collects all remaining objects of this iteration into a list.
     *
     * @return a list with all remaining objects of this iteration
     */
    @Override
    public List<E> asList() {
        return FluentIterable.copyToList(this.iterable);
    }

    @Override
    public Iterator<E> iterator() {
        return new DecoratingIterator<E>(this.iterable.iterator()) {
            @Override
            public E computeNext() {
                return this.fromIterator.hasNext() ? this.fromIterator.next() : null;
            }
        };
    }

    /**
     * @return a FluentIterable from a given iterable. Calls the LazyFluentIterable constructor.
     */
    public static final <E> FluentIterable<E> from(final Iterable<E> iterable) {
        return new LazyFluentIterable<>(iterable);
    }
}
