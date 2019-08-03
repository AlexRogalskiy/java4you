package com.sensiblemetrics.api.alpenidos.core.event.aggregator.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Event enumeration.
 */
@Getter
@RequiredArgsConstructor
public enum Event {
    STARK_SIGHTED("Stark sighted"),
    WARSHIPS_APPROACHING("Warships approaching"),
    TRAITOR_DETECTED("Traitor detected");

    private final String description;

    public String toString() {
        return this.description;
    }
}
