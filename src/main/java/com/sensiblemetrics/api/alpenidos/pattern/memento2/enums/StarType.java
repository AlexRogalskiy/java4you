package com.sensiblemetrics.api.alpenidos.pattern.memento2.enums;

import lombok.RequiredArgsConstructor;

/**
 * StarType enumeration
 */
@RequiredArgsConstructor
public enum StarType {
    SUN("sun"),
    RED_GIANT("red giant"),
    WHITE_DWARF("white dwarf"),
    SUPERNOVA("supernova"),
    DEAD("dead star"),
    UNDEFINED("");

    private final String title;

    @Override
    public String toString() {
        return this.title;
    }
}
