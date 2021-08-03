package com.sensiblemetrics.api.alpenidos.pattern.mediator2.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Action enumeration.
 */
@Getter
@RequiredArgsConstructor
public enum Action {
    HUNT("hunted a rabbit", "arrives for dinner"),
    TALE("tells a tale", "comes to listen"),
    GOLD("found gold", "takes his share of the gold"),
    ENEMY("spotted enemies", "runs for cover"),
    NONE("", "");

    private final String title;
    private final String description;
}
