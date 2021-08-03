package com.sensiblemetrics.api.alpenidos.pattern.factory_method.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * WeaponType enumeration
 **/
@Getter
@RequiredArgsConstructor
public enum WeaponType {
    SHORT_SWORD("short sword"),
    SPEAR("spear"),
    AXE("axe"),
    UNDEFINED("");

    private final String title;

    @Override
    public String toString() {
        return this.title;
    }
}
