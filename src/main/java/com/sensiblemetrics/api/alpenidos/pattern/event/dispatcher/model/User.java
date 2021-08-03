package com.sensiblemetrics.api.alpenidos.pattern.event.dispatcher.model;

import com.sensiblemetrics.api.alpenidos.pattern.event.dispatcher.event.UserCreatedEvent;
import com.sensiblemetrics.api.alpenidos.pattern.event.dispatcher.event.UserUpdatedEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This {@link User} class is a basic pojo used to demonstrate user data sent along with
 * the {@link UserCreatedEvent} and {@link UserUpdatedEvent} events.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String username;
}
