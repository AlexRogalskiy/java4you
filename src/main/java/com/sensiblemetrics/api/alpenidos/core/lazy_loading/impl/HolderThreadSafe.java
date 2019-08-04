package com.sensiblemetrics.api.alpenidos.core.lazy_loading.impl;

import com.sensiblemetrics.api.alpenidos.core.lazy_loading.iface.Holder;
import com.sensiblemetrics.api.alpenidos.core.lazy_loading.model.Heavy;
import lombok.extern.slf4j.Slf4j;

/**
 * Same as HolderNaive but with added synchronization. This implementation is thread safe, but each
 * {@link #get()} call costs additional synchronization overhead.
 */
@Slf4j
public class HolderThreadSafe implements Holder<Heavy> {
    private Heavy heavy;

    /**
     * Constructor
     */
    public HolderThreadSafe() {
        log.info("HolderThreadSafe created");
    }

    /**
     * Get heavy object
     */
    @Override
    public synchronized Heavy get() {
        if (this.heavy == null) {
            this.heavy = new Heavy();
        }
        return this.heavy;
    }
}
