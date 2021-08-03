package com.sensiblemetrics.api.alpenidos.pattern.event.dispatcher.event;

import com.sensiblemetrics.api.alpenidos.pattern.event.dispatcher.model.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * The {@link UserUpdatedEvent} should should be dispatched whenever a user has been updated.
 * This class can be extended to contain details about the user has been updated. In this example,
 * the entire {@link User} object is passed on as data with the event.
 */
@Getter
@RequiredArgsConstructor
public class UserUpdatedEvent extends AbstractEvent {
    private final User user;
}
