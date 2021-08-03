package com.sensiblemetrics.api.alpenidos.pattern.mvc.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Nourishment enumeration
 */
@Getter
@RequiredArgsConstructor
public enum Nourishment {
    SATURATED("saturated"),
    HUNGRY("hungry"),
    STARVING("starving");

    private final String title;

    @Override
    public String toString() {
        return this.title;
    }
}
