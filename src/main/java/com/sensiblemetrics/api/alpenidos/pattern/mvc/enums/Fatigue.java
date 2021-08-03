package com.sensiblemetrics.api.alpenidos.pattern.mvc.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Fatigue enumeration
 */
@Getter
@RequiredArgsConstructor
public enum Fatigue {
    ALERT("alert"),
    TIRED("tired"),
    SLEEPING("sleeping");

    private final String title;

    @Override
    public String toString() {
        return this.title;
    }
}
