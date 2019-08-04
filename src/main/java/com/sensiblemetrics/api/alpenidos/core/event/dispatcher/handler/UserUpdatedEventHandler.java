package com.sensiblemetrics.api.alpenidos.core.event.dispatcher.handler;

import com.sensiblemetrics.api.alpenidos.core.event.dispatcher.event.UserUpdatedEvent;
import com.sensiblemetrics.api.alpenidos.core.event.dispatcher.framework.Handler;
import lombok.extern.slf4j.Slf4j;

/**
 * Handles the {@link UserUpdatedEvent} message.
 */
@Slf4j
public class UserUpdatedEventHandler implements Handler<UserUpdatedEvent> {

    @Override
    public void onEvent(final UserUpdatedEvent event) {
        log.info("User '{}' has been Updated!", event.getUser().getUsername());
    }
}
