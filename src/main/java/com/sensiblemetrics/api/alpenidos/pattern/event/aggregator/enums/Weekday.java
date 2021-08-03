package com.sensiblemetrics.api.alpenidos.pattern.event.aggregator.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Weekday enumeration
 */
@Getter
@RequiredArgsConstructor
public enum Weekday {
    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday"),
    SATURDAY("Saturday"),
    SUNDAY("Sunday");

    private final String description;

    public String toString() {
        return this.description;
    }
}
