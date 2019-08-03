package com.sensiblemetrics.api.alpenidos.core.async_method_invocation.iface;

import java.util.Optional;

/**
 * AsyncCallback interface
 *
 * @param <T>
 */
public interface AsyncCallback<T> {

    /**
     * Complete handler which is executed when async task is completed or fails execution.
     *
     * @param value the evaluated value from async task, undefined when execution fails
     * @param ex    empty value if execution succeeds, some exception if executions fails
     */
    void onComplete(final T value, final Optional<Exception> ex);
}
