package com.sensiblemetrics.api.alpenidos.pattern.observer2.iface;

import com.sensiblemetrics.api.alpenidos.pattern.observer2.enums.WeatherType;

/**
 * Observer interface.
 */
public interface WeatherObserver {

    void update(final WeatherType currentWeather);
}
