package com.sensiblemetrics.api.alpenidos.pattern.lazy_loading;

import com.sensiblemetrics.api.alpenidos.pattern.lazy_loading.iface.Holder;
import com.sensiblemetrics.api.alpenidos.pattern.lazy_loading.impl.HolderNaive;
import com.sensiblemetrics.api.alpenidos.pattern.lazy_loading.impl.HolderThreadSafe;
import com.sensiblemetrics.api.alpenidos.pattern.lazy_loading.impl.Java8Holder;
import com.sensiblemetrics.api.alpenidos.pattern.lazy_loading.model.Heavy;
import lombok.extern.slf4j.Slf4j;

/**
 * Lazy loading idiom defers object creation until needed.
 * <p>
 * This example shows different implementations of the pattern with increasing sophistication.
 * <p>
 * Additional information and lazy loading flavours are described in
 * http://martinfowler.com/eaaCatalog/lazyLoad.html
 */
@Slf4j
public class LazyLoadingPatternLoader {

    /**
     * Program entry point
     *
     * @param args command line args
     */
    public static void main(final String[] args) {
        // Simple lazy loader - not thread safe
        final Holder<Heavy> holderNaive = new HolderNaive();
        final Heavy heavy = holderNaive.get();
        log.info("heavy={}", heavy);

        // Thread safe lazy loader, but with heavy synchronization on each access
        final Holder<Heavy> holderThreadSafe = new HolderThreadSafe();
        final Heavy another = holderThreadSafe.get();
        log.info("another={}", another);

        // The most efficient lazy loader utilizing Java 8 features
        final Holder<Heavy> java8Holder = new Java8Holder();
        final Heavy next = java8Holder.get();
        log.info("next={}", next);
    }
}
