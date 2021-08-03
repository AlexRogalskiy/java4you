package com.sensiblemetrics.api.alpenidos.pattern.builder2.enums;

/**
 * Profession enumeration
 */
public enum Profession {
    WARRIOR,
    THIEF,
    MAGE,
    PRIEST;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
