package com.sensiblemetrics.api.alpenidos.core.observer2.observable;

import com.sensiblemetrics.api.alpenidos.core.observer2.enums.WeatherType;
import com.sensiblemetrics.api.alpenidos.core.observer2.iface.Race;
import lombok.extern.slf4j.Slf4j;

/**
 * GWeather
 */
@Slf4j
public class GWeather extends Observable<GWeather, Race, WeatherType> {
    private WeatherType currentWeather;

    public GWeather() {
        this.currentWeather = WeatherType.SUNNY;
    }

    /**
     * Makes time pass for weather
     */
    public void timePasses() {
        final WeatherType[] enumValues = WeatherType.values();
        this.currentWeather = enumValues[(this.currentWeather.ordinal() + 1) % enumValues.length];
        log.info("The weather changed to {}.", currentWeather);
        this.notifyObservers(this.currentWeather);
    }
}
