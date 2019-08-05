package com.sensiblemetrics.api.alpenidos.core.specification.property;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Movement property.
 */
@Getter
@RequiredArgsConstructor
public enum Movement {
    WALKING("walking"),
    SWIMMING("swimming"),
    FLYING("flying");

    private final String title;

    @Override
    public String toString() {
        return this.title;
    }
}
