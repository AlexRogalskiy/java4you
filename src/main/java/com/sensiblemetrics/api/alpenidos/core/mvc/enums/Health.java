package com.sensiblemetrics.api.alpenidos.core.mvc.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Health enumeration
 */
@Getter
@RequiredArgsConstructor
public enum Health {
    HEALTHY("healthy"),
    WOUNDED("wounded"),
    DEAD("dead");

    private final String title;

    @Override
    public String toString() {
        return this.title;
    }
}
