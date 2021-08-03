package com.sensiblemetrics.api.alpenidos.pattern.retry.exception;

/**
 * Indicates that the customer was not found.
 * <p>
 * The severity of this error is bounded by its context: was the search for the customer triggered
 * by an input from some end user, or were the search parameters pulled from your database?
 *
 * @author George Aristy (george.aristy@gmail.com)
 */
public final class CustomerNotFoundException extends BusinessException {

    private static final long serialVersionUID = -8958424830838961207L;

    /**
     * Ctor.
     *
     * @param message the error message
     */
    public CustomerNotFoundException(final String message) {
        super(message);
    }
}
