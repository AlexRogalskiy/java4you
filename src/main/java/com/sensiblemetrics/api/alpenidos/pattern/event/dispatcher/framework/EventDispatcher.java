package com.sensiblemetrics.api.alpenidos.pattern.event.dispatcher.framework;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Handles the routing of {@link Event} messages to associated handlers.
 * A {@link HashMap} is used to store the association between events and their respective handlers.
 */
public class EventDispatcher {

    private Map<Class<? extends Event>, Handler<? extends Event>> handlers;

    public EventDispatcher() {
        this.handlers = new HashMap<>();
    }

    /**
     * Links an {@link Event} to a specific {@link Handler}.
     *
     * @param eventType The {@link Event} to be registered
     * @param handler   The {@link Handler} that will be handling the {@link Event}
     */
    public <E extends Event> void registerHandler(final Class<E> eventType, final Handler<E> handler) {
        this.handlers.put(eventType, handler);
    }

    /**
     * Dispatches an {@link Event} depending on it's type.
     *
     * @param event The {@link Event} to be dispatched
     */
    @SuppressWarnings("unchecked")
    public <E extends Event> void dispatch(final E event) {
        Optional.ofNullable(this.handlers.get(event.getClass())).map(h -> (Handler<Event>) h).ifPresent(h -> h.onEvent(event));
    }
}
