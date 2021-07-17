package com.sensiblemetrics.api.alpenidos.core.utils;

import io.vavr.collection.List;

public interface DomainEvents {

    void publish(DomainEvent event);

    default void publish(List<DomainEvent> events) {
        events.forEach(this::publish);
    }
}
