package com.sensiblemetrics.api.alpenidos.core.pool_object.exception;

public class DuplicatedInstanceException extends Exception {

    public DuplicatedInstanceException() {
        super("Ya existe esa instancia en el pool.");
    }
}
