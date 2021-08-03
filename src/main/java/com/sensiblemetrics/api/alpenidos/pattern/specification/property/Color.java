package com.sensiblemetrics.api.alpenidos.pattern.specification.property;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Color property.
 */
@Getter
@RequiredArgsConstructor
public enum Color {
    DARK("dark"),
    LIGHT("light"),
    GREEN("green"),
    RED("red");

    private final String title;

    @Override
    public String toString() {
        return this.title;
    }
}
