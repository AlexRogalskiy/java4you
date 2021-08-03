package com.sensiblemetrics.api.alpenidos.pattern.builder2.enums;

/**
 * HairColorType enumeration
 */
public enum HairColorType {
    WHITE,
    BLOND,
    RED,
    BROWN,
    BLACK;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
