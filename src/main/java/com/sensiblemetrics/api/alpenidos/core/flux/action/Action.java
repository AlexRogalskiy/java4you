package com.sensiblemetrics.api.alpenidos.core.flux.action;

import com.sensiblemetrics.api.alpenidos.core.flux.action.enums.ActionType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Action is the data payload dispatched to the stores when something happens.
 */
@Getter
@RequiredArgsConstructor
public abstract class Action {
    private final ActionType type;
}
