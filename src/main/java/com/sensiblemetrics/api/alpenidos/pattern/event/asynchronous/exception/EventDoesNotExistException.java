package com.sensiblemetrics.api.alpenidos.pattern.event.asynchronous.exception;

/**
 * Custom Exception Class for Non Existent Event
 */
public class EventDoesNotExistException extends Exception {

    private static final long serialVersionUID = 6579888399668229536L;

    public EventDoesNotExistException(final String message) {
        super(message);
    }
}
