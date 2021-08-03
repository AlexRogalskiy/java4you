package com.sensiblemetrics.api.alpenidos.pattern.future.iface;

import com.sensiblemetrics.api.alpenidos.pattern.future.model.Coordinate;

/**
 * Based on: "Patterns in Java", Mark Grand.
 */
public interface IWeatherFetch {

    IWeatherFetch fetchWeather(final Coordinate location);
}
