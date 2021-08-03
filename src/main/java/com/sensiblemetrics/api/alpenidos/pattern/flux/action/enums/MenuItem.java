package com.sensiblemetrics.api.alpenidos.pattern.flux.action.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Menu items.
 */
@Getter
@RequiredArgsConstructor
public enum MenuItem {
    HOME("Home"),
    PRODUCTS("Products"),
    COMPANY("Company");

    private final String title;

    @Override
    public String toString() {
        return this.title;
    }
}
