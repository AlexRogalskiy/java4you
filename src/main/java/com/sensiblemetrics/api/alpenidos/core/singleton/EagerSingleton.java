package com.sensiblemetrics.api.alpenidos.core.singleton;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EagerSingleton {
    private static EagerSingleton instance = new EagerSingleton();

    /**
     * @return
     */
    public static EagerSingleton getInstance() {
        return instance;
    }
}
