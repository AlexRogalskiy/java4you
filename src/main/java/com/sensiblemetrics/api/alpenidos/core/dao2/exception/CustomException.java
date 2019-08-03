package com.sensiblemetrics.api.alpenidos.core.dao2.exception;

/**
 * Custom exception
 */
public class CustomException extends Exception {

    private static final long serialVersionUID = 7442475818113756727L;

    public CustomException() {
    }

    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }
}
