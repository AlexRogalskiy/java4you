package com.sensiblemetrics.api.alpenidos.pattern.lazy_loading.impl;

import com.sensiblemetrics.api.alpenidos.pattern.lazy_loading.iface.Holder;
import com.sensiblemetrics.api.alpenidos.pattern.lazy_loading.model.Heavy;
import lombok.extern.slf4j.Slf4j;

/**
 * Simple implementation of the lazy loading idiom. However, this is not thread safe.
 */
@Slf4j
public class HolderNaive implements Holder<Heavy> {
    private Heavy heavy;

    /**
     * Constructor
     */
    public HolderNaive() {
        log.info("HolderNaive created");
    }

    /**
     * Get heavy object
     */
    @Override
    public Heavy get() {
        if (this.heavy == null) {
            this.heavy = new Heavy();
        }
        return this.heavy;
    }
}
