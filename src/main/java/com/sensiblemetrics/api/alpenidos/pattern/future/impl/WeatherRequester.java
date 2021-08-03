package com.sensiblemetrics.api.alpenidos.pattern.future.impl;

import com.sensiblemetrics.api.alpenidos.pattern.future.iface.IWeatherFetch;
import com.sensiblemetrics.api.alpenidos.pattern.future.model.Coordinate;
import lombok.RequiredArgsConstructor;

/**
 * Based on: "Patterns in Java", Mark Grand.
 */
@RequiredArgsConstructor
public class WeatherRequester {
    private final IWeatherFetch fetcher;

    public synchronized WeatherFuture getWeather(final Coordinate location) {
        return new WeatherFuture(this.fetcher, location);
    }
}
