package com.sensiblemetrics.api.alpenidos.pattern.balking.iface;

import java.util.concurrent.TimeUnit;

/**
 * An interface to simulate delay while executing some work.
 */
public interface DelayProvider {

    void executeAfterDelay(final long interval, final TimeUnit timeUnit, final Runnable task);
}
