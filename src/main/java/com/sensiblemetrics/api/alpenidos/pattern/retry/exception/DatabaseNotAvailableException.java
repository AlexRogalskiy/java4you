package com.sensiblemetrics.api.alpenidos.pattern.retry.exception;

/**
 * Catastrophic error indicating that we have lost connection to our database.
 *
 * @author George Aristy (george.aristy@gmail.com)
 */
public final class DatabaseNotAvailableException extends BusinessException {

    private static final long serialVersionUID = 3932824206574171545L;

    /**
     * Ctor.
     *
     * @param message the error message
     */
    public DatabaseNotAvailableException(final String message) {
        super(message);
    }
}
