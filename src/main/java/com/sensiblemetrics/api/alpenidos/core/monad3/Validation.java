package com.sensiblemetrics.api.alpenidos.core.monad3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

/**
 * @author Alexander Pashinskiy
 * @version 1.0
 * @since 5/12/2015
 */
public class Validation<T> {

    private final T obj;
    private final List<ValidationError> errors;

    private Validation(T obj, List<ValidationError> errors) {
        this.obj = Objects.requireNonNull(obj);
        this.errors = errors;
    }

    public static <T> Validation<T> of(T t) {
        return success(t);
    }

    public static <T> Validation<T> success(T t) {
        return new Validation<>(t, new ArrayList<>());
    }

    public static <T> Validation<T> failure(T t, String s) {
        return new Validation<>(t, Collections.singletonList(new ValidationError(s)));
    }

    public Validation<T> andThan(final Function<T, Validation<T>> validator) {
        final Validation<T> result = validator.apply(this.obj);
        this.errors.addAll(result.errors);
        return new Validation<>(this.obj, new ArrayList<>(this.errors));
    }

    public T get() throws ValidationError {
        if (this.errors.isEmpty()) {
            return this.obj;
        }

        final ValidationError error = new ValidationError("User Validation Exception");
        this.errors.forEach(error::addSuppressed);
        throw error;
    }
}
