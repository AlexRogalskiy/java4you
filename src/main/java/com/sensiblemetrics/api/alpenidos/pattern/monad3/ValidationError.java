package com.sensiblemetrics.api.alpenidos.pattern.monad3;

/**
 * @author Alexander Pashinskiy
 * @version 1.0
 * @since 5/12/2015
 */
public class ValidationError extends IllegalStateException {

    public ValidationError(String validationMessage) {
        super(validationMessage);
    }
}
