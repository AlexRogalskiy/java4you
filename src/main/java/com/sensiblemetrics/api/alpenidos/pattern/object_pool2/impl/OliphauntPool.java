package com.sensiblemetrics.api.alpenidos.pattern.object_pool2.impl;

import com.sensiblemetrics.api.alpenidos.pattern.object_pool2.pool.ObjectPool;

/**
 * Oliphaunt object pool
 */
public class OliphauntPool extends ObjectPool<Oliphaunt> {

    @Override
    protected Oliphaunt create() {
        return new Oliphaunt();
    }
}
