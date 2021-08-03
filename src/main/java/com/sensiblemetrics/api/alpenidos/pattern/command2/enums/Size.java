package com.sensiblemetrics.api.alpenidos.pattern.command2.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enumeration for target size.
 */
@Getter
@RequiredArgsConstructor
public enum Size {
    SMALL("small"),
    NORMAL("normal");

    private final String title;

    @Override
    public String toString() {
        return this.title;
    }
}
