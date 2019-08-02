package com.sensiblemetrics.api.alpenidos.core.abstract_document.impl;

import com.sensiblemetrics.api.alpenidos.core.abstract_document.iface.Document;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Abstract implementation of Document interface
 */
public abstract class AbstractDocument implements Document {

    private final Map<String, Object> properties;

    protected AbstractDocument(final Map<String, Object> properties) {
        Objects.requireNonNull(properties, "Properties map is required");
        this.properties = properties;
    }

    @Override
    public Void put(final String key, final Object value) {
        this.properties.put(key, value);
        return null;
    }

    @Override
    public Object get(final String key) {
        return this.properties.get(key);
    }

    @Override
    public <T> Stream<T> children(final String key, final Function<Map<String, Object>, T> constructor) {
        final Optional<List<Map<String, Object>>> any = Stream.of(get(key)).filter(el -> el != null).map(el -> (List<Map<String, Object>>) el).findAny();
        return any.isPresent() ? any.get().stream().map(constructor) : Stream.empty();
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getClass().getName()).append("[");
        this.properties.entrySet().forEach(e -> builder.append("[").append(e.getKey()).append(" : ").append(e.getValue()).append("]"));
        builder.append("]");
        return builder.toString();
    }
}
