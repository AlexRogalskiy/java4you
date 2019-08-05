package com.sensiblemetrics.api.alpenidos.core.singleton;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClassSingleton {
    private static ClassSingleton INSTANCE;
    private String info = "Initial class info";

    public static ClassSingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ClassSingleton();
        }
        return INSTANCE;
    }
}
