package com.sensiblemetrics.api.alpenidos.pattern.event.dispatcher.event;

import com.sensiblemetrics.api.alpenidos.pattern.event.dispatcher.model.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * The {@link UserCreatedEvent} should should be dispatched whenever a user has been created.
 * This class can be extended to contain details about the user has been created. In this example,
 * the entire {@link User} object is passed on as data with the event.
 */
@Getter
@RequiredArgsConstructor
public class UserCreatedEvent extends AbstractEvent {
    private final User user;
}
