package com.sensiblemetrics.api.alpenidos.core.specification.property;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Size property.
 */
@Getter
@RequiredArgsConstructor
public enum Size {
    SMALL("small"),
    NORMAL("normal"),
    LARGE("large");

    private final String title;

    @Override
    public String toString() {
        return this.title;
    }
}
