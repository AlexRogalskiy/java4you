package com.sensiblemetrics.api.alpenidos.pattern.object_pool2.pool;

import java.util.HashSet;
import java.util.Set;

/**
 * Generic object pool
 *
 * @param <T> Type T of Object in the Pool
 */
public abstract class ObjectPool<T> {
    private Set<T> available = new HashSet<>();
    private Set<T> inUse = new HashSet<>();

    protected abstract T create();

    /**
     * Checkout object from pool
     */
    public synchronized T checkOut() {
        if (this.available.isEmpty()) {
            this.available.add(this.create());
        }
        final T instance = this.available.iterator().next();
        this.available.remove(instance);
        this.inUse.add(instance);
        return instance;
    }

    public synchronized void checkIn(final T instance) {
        this.inUse.remove(instance);
        this.available.add(instance);
    }

    @Override
    public synchronized String toString() {
        return String.format("Pool available=%d inUse=%d", this.available.size(), this.inUse.size());
    }
}
