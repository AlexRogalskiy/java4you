package com.sensiblemetrics.api.alpenidos.core.observer2.iface;

import com.sensiblemetrics.api.alpenidos.core.observer2.enums.WeatherType;

/**
 * Observer interface.
 */
public interface WeatherObserver {

    void update(final WeatherType currentWeather);
}
