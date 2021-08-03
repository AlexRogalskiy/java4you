package com.sensiblemetrics.api.alpenidos.pattern.pool_object.exception;

public class NotFreeInstanceException extends Exception {

    private static final long serialVersionUID = -8783743636346680638L;

    public NotFreeInstanceException() {
        super("No hay más instancias reutilizables disponibles. Reintentalo más tarde");
    }
}
