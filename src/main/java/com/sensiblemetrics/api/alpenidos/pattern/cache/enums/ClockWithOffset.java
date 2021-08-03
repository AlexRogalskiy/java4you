package com.sensiblemetrics.api.alpenidos.pattern.cache.enums;

import com.sensiblemetrics.api.alpenidos.pattern.cache.iface.Clock;

public enum ClockWithOffset implements Clock {
    /**
     * Singleton.
     */
    INSTANCE;

    private volatile long offset = 0L;

    /**
     * Sets the offset for the clock.
     *
     * @param offset Number of milliseconds to add to the current time.
     */
    public void setOffset(final long offset) {
        if (offset >= 0) {
            this.offset = offset;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long now() {
        return this.offset + System.currentTimeMillis();
    }
}
