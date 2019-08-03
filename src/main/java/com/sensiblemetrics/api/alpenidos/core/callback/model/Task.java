package com.sensiblemetrics.api.alpenidos.core.callback.model;

import com.sensiblemetrics.api.alpenidos.core.callback.iface.Callback;

import java.util.Optional;

/**
 * Template-method class for callback hook execution
 */
public abstract class Task {

    /**
     * Execute with callback
     */
    public final void executeWith(final Callback callback) {
        this.execute();
        Optional.ofNullable(callback).ifPresent(Callback::call);
    }

    public abstract void execute();
}
