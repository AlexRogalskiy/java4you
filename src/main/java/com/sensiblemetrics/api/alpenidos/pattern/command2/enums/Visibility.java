package com.sensiblemetrics.api.alpenidos.pattern.command2.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enumeration for target visibility.
 */
@Getter
@RequiredArgsConstructor
public enum Visibility {
    VISIBLE("visible"),
    INVISIBLE("invisible");

    private final String title;

    @Override
    public String toString() {
        return this.title;
    }
}
