package com.sensiblemetrics.api.alpenidos.core.semaphore.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Fruit is a resource stored in a FruitBowl.
 */
@Getter
@RequiredArgsConstructor
public class Fruit {

    /**
     * Enumeration of Fruit Types
     */
    public enum FruitType {
        ORANGE, APPLE, LEMON
    }

    private final FruitType type;

    /**
     * toString method
     */
    public String toString() {
        switch (type) {
            case ORANGE:
                return "Orange";
            case APPLE:
                return "Apple";
            case LEMON:
                return "Lemon";
            default:
                return "";
        }
    }
}
