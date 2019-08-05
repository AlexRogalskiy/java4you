package com.sensiblemetrics.api.alpenidos.core.observer2.observable;

import com.sensiblemetrics.api.alpenidos.core.observer2.enums.WeatherType;
import com.sensiblemetrics.api.alpenidos.core.observer2.iface.WeatherObserver;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Weather can be observed by implementing {@link WeatherObserver} interface and registering as
 * listener.
 */
@Slf4j
public class Weather {
    private WeatherType currentWeather;
    private List<WeatherObserver> observers;

    public Weather() {
        this.observers = new ArrayList<>();
        this.currentWeather = WeatherType.SUNNY;
    }

    public void addObserver(final WeatherObserver obs) {
        this.observers.add(obs);
    }

    public void removeObserver(final WeatherObserver obs) {
        this.observers.remove(obs);
    }

    /**
     * Makes time pass for weather
     */
    public void timePasses() {
        final WeatherType[] enumValues = WeatherType.values();
        this.currentWeather = enumValues[(this.currentWeather.ordinal() + 1) % enumValues.length];
        log.info("The weather changed to {}.", currentWeather);
        this.notifyObservers();
    }

    private void notifyObservers() {
        this.observers.forEach(o -> o.update(this.currentWeather));
    }
}
