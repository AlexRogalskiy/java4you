package com.sensiblemetrics.api.alpenidos.core.observer2.enums;

/**
 * WeatherType enumeration
 */
public enum WeatherType {
    SUNNY,
    RAINY,
    WINDY,
    COLD;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
