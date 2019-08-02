package com.sensiblemetrics.api.alpenidos.core.abstract_document.iface;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Document interface
 */
public interface Document {

    /**
     * Puts the value related to the key
     *
     * @param key   element key
     * @param value element value
     * @return Void
     */
    Void put(final String key, final Object value);

    /**
     * Gets the value for the key
     *
     * @param key element key
     * @return value or null
     */
    Object get(final String key);

    /**
     * Gets the stream of child documents
     *
     * @param key         element key
     * @param constructor constructor of child class
     * @return child documents
     */
    <T> Stream<T> children(final String key, final Function<Map<String, Object>, T> constructor);
}
