package com.sensiblemetrics.api.alpenidos.pattern.lazy_loading.impl;

import com.sensiblemetrics.api.alpenidos.pattern.lazy_loading.iface.Holder;
import com.sensiblemetrics.api.alpenidos.pattern.lazy_loading.model.Heavy;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Supplier;

/**
 * This lazy loader is thread safe and more efficient than {@link HolderThreadSafe}. It utilizes
 * Java 8 functional interface {@link Supplier} as {@link Heavy} factory.
 */
@Slf4j
public class Java8Holder implements Holder<Heavy> {

    private Supplier<Heavy> heavy = this::createAndCacheHeavy;

    public Java8Holder() {
        log.info("Java8Holder created");
    }

    @Override
    public Heavy get() {
        return this.heavy.get();
    }

    private synchronized Heavy createAndCacheHeavy() {
        class HeavyFactory implements Supplier<Heavy> {
            private final Heavy heavyInstance = new Heavy();

            @Override
            public Heavy get() {
                return this.heavyInstance;
            }
        }
        if (!HeavyFactory.class.isInstance(this.heavy)) {
            this.heavy = new HeavyFactory();
        }
        return this.heavy.get();
    }
}
