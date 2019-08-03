package com.sensiblemetrics.api.alpenidos.core.event.asynchronous.exception;

/**
 * Type of Exception raised when the Operation being invoked is Invalid
 */
public class InvalidOperationException extends Exception {

    private static final long serialVersionUID = -6191545255213410803L;

    public InvalidOperationException(final String message) {
        super(message);
    }

}
