package com.sensiblemetrics.api.alpenidos.pattern.event.asynchronous.exception;

/**
 * Type of Exception raised when the Operation being invoked is Long Running
 */
public class LongRunningEventException extends Exception {

    private static final long serialVersionUID = -483423544320148809L;

    public LongRunningEventException(final String message) {
        super(message);
    }
}
