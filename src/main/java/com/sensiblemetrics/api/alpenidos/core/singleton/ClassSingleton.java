package com.sensiblemetrics.api.alpenidos.core.singleton;

import lombok.Data;

@Data
public class ClassSingleton {
    private static ClassSingleton INSTANCE;
    private String info = "Initial class info";

    private ClassSingleton() {
    }

    public static ClassSingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ClassSingleton();
        }
        return INSTANCE;
    }
}
