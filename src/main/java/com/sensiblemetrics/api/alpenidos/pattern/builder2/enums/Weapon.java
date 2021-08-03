package com.sensiblemetrics.api.alpenidos.pattern.builder2.enums;

/**
 * Weapon enumeration
 */
public enum Weapon {
    DAGGER,
    SWORD,
    AXE,
    WARHAMMER,
    BOW;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
