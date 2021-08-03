package com.sensiblemetrics.api.alpenidos.pattern.builder2.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * HairType enumeration
 */
@Getter
@RequiredArgsConstructor
public enum HairType {
    BALD("bald"),
    SHORT("short"),
    CURLY("curly"),
    LONG_STRAIGHT("long straight"),
    LONG_CURLY("long curly");

    private final String title;

    @Override
    public String toString() {
        return title;
    }
}
