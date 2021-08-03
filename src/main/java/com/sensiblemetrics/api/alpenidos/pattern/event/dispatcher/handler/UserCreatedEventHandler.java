package com.sensiblemetrics.api.alpenidos.pattern.event.dispatcher.handler;

import com.sensiblemetrics.api.alpenidos.pattern.event.dispatcher.event.UserCreatedEvent;
import com.sensiblemetrics.api.alpenidos.pattern.event.dispatcher.framework.Handler;
import lombok.extern.slf4j.Slf4j;

/**
 * Handles the {@link UserCreatedEvent} message.
 */
@Slf4j
public class UserCreatedEventHandler implements Handler<UserCreatedEvent> {

    @Override
    public void onEvent(final UserCreatedEvent event) {
        log.info("User '{}' has been Created!", event.getUser().getUsername());
    }
}
