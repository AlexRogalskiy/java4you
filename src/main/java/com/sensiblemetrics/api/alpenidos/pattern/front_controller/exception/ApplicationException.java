package com.sensiblemetrics.api.alpenidos.pattern.front_controller.exception;

/**
 * Custom exception type
 */
public class ApplicationException extends RuntimeException {

    private static final long serialVersionUID = 6333128284160049482L;

    public ApplicationException(final Throwable cause) {
        super(cause);
    }
}
