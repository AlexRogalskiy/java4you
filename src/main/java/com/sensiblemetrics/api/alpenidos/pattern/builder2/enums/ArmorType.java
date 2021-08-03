package com.sensiblemetrics.api.alpenidos.pattern.builder2.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * ArmorType enumeration
 */
@Getter
@RequiredArgsConstructor
public enum ArmorType {
    CLOTHES("clothes"),
    LEATHER("leather"),
    CHAIN_MAIL("chain mail"),
    PLATE_MAIL("plate mail");

    private final String title;

    @Override
    public String toString() {
        return title;
    }
}
