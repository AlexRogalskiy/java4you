package com.sensiblemetrics.api.alpenidos.core.singleton;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Singleton {
    private static Singleton singleton;
    private String message;

    public static Singleton instance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}
