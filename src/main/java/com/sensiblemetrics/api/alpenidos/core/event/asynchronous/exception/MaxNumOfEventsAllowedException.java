package com.sensiblemetrics.api.alpenidos.core.event.asynchronous.exception;

/**
 * Type of Exception raised when the max number of allowed events is exceeded
 */
public class MaxNumOfEventsAllowedException extends Exception {

    private static final long serialVersionUID = -8430876973516292695L;

    public MaxNumOfEventsAllowedException(final String message) {
        super(message);
    }
}
