package com.sensiblemetrics.api.alpenidos.pattern.retry.exception;

/**
 * The top-most type in our exception hierarchy that signifies that an unexpected error
 * condition occurred. Its use is reserved as a "catch-all" for cases where no other subtype
 * captures the specificity of the error condition in question. Calling code is not expected to
 * be able to handle this error and should be reported to the maintainers immediately.
 *
 * @author George Aristy (george.aristy@gmail.com)
 */
public class BusinessException extends Exception {

    private static final long serialVersionUID = -5909341866244489369L;

    /**
     * Ctor
     *
     * @param message the error message
     */
    public BusinessException(final String message) {
        super(message);
    }
}
