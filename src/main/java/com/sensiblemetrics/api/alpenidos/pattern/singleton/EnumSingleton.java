package com.sensiblemetrics.api.alpenidos.pattern.singleton;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EnumSingleton {
    INSTANCE("Initial enum info");

    private final String info;

    public EnumSingleton getInstance() {
        return INSTANCE;
    }
}
