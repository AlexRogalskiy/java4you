package com.sensiblemetrics.api.alpenidos.core.private_class_data.impl;

import lombok.extern.slf4j.Slf4j;

/**
 * Immutable stew class, protected with Private Class Data pattern
 */
@Slf4j
public class ImmutableStew {
    private final StewData data;

    public ImmutableStew(final int numPotatoes, final int numCarrots, final int numMeat, final int numPeppers) {
        this.data = new StewData(numPotatoes, numCarrots, numMeat, numPeppers);
    }

    /**
     * Mix the stew
     */
    public void mix() {
        log.info("Mixing the immutable stew we find: {} potatoes, {} carrots, {} meat and {} peppers",
            this.data.getNumPotatoes(), this.data.getNumCarrots(), this.data.getNumMeat(), this.data.getNumPeppers());
    }
}
