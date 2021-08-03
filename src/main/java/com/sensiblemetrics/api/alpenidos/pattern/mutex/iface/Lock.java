package com.sensiblemetrics.api.alpenidos.pattern.mutex.iface;

/**
 * Lock is an interface for a lock which can be acquired and released.
 */
public interface Lock {

    void acquire() throws InterruptedException;

    void release();
}
