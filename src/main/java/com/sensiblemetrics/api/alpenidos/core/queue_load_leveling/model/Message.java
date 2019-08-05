package com.sensiblemetrics.api.alpenidos.core.queue_load_leveling.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Message class with only one parameter.
 */
@Getter
@RequiredArgsConstructor
public class Message {
    private final String msg;

    @Override
    public String toString() {
        return this.msg;
    }
}
