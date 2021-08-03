package com.sensiblemetrics.api.alpenidos.pattern.cache.iface;

public interface Clock {
    /**
     * A Clock instance that returns the current time in milliseconds since
     * the epoch using the system clock.
     */
    Clock WALL = System::currentTimeMillis;

    /**
     * Returns the number of milliseconds since the epoch.
     */
    long now();
}
