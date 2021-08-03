package com.sensiblemetrics.api.alpenidos.pattern.proxy2.model;

import lombok.RequiredArgsConstructor;

/**
 * Wizard
 */
@RequiredArgsConstructor
public class Wizard {
    private final String name;

    @Override
    public String toString() {
        return this.name;
    }
}
