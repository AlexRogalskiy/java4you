package com.sensiblemetrics.api.alpenidos.core.flux.action.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Content items.
 */
@Getter
@RequiredArgsConstructor
public enum Content {
    PRODUCTS("Products - This page lists the company's products."),
    COMPANY("Company - This page displays information about the company.");

    private final String title;

    @Override
    public String toString() {
        return this.title;
    }
}
