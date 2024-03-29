package com.sensiblemetrics.api.alpenidos.pattern.event.dispatcher;

import com.sensiblemetrics.api.alpenidos.pattern.event.dispatcher.event.UserCreatedEvent;
import com.sensiblemetrics.api.alpenidos.pattern.event.dispatcher.event.UserUpdatedEvent;
import com.sensiblemetrics.api.alpenidos.pattern.event.dispatcher.framework.Event;
import com.sensiblemetrics.api.alpenidos.pattern.event.dispatcher.framework.EventDispatcher;
import com.sensiblemetrics.api.alpenidos.pattern.event.dispatcher.handler.UserCreatedEventHandler;
import com.sensiblemetrics.api.alpenidos.pattern.event.dispatcher.handler.UserUpdatedEventHandler;
import com.sensiblemetrics.api.alpenidos.pattern.event.dispatcher.model.User;

/**
 * An event-driven architecture (EDA) is a framework that orchestrates behavior around the
 * production, detection and consumption of events as well as the responses they evoke. An event is
 * any identifiable occurrence that has significance for system hardware or software. <p> The
 * example below uses an {@link EventDispatcher} to link/register {@link Event} objects to their
 * respective handlers once an {@link Event} is dispatched, it's respective handler is invoked and
 * the {@link Event} is handled accordingly.
 */
public class EventDispatcherPatternLoader {

    /**
     * Once the {@link EventDispatcher} is initialised, handlers related to specific events have to be
     * made known to the dispatcher by registering them. In this case the {@link UserCreatedEvent} is
     * bound to the UserCreatedEventHandler, whilst the {@link UserUpdatedEvent} is bound to the
     * {@link UserUpdatedEventHandler}. The dispatcher can now be called to dispatch specific events.
     * When a user is saved, the {@link UserCreatedEvent} can be dispatched.
     * On the other hand, when a user is updated, {@link UserUpdatedEvent} can be dispatched.
     */
    public static void main(final String[] args) {
        final EventDispatcher dispatcher = new EventDispatcher();
        dispatcher.registerHandler(UserCreatedEvent.class, new UserCreatedEventHandler());
        dispatcher.registerHandler(UserUpdatedEvent.class, new UserUpdatedEventHandler());

        final User user = new User("test");
        dispatcher.dispatch(new UserCreatedEvent(user));
        dispatcher.dispatch(new UserUpdatedEvent(user));
    }
}
