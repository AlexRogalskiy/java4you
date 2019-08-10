package com.sensiblemetrics.api.alpenidos.core.lock_object;

import lombok.Data;

/**
 * Based on: "Patterns in Java", Mark Grand.
 */
@Data
public abstract class AbstractGameObject {
    private final static Object lockObject = new Object();
    private boolean glowing;

    public final Object getLockObject() {
        return lockObject;
    }
}
