package com.sensiblemetrics.api.alpenidos.core.readonly.iface;

public interface TemperatureIF {

    double getTemperature();

    void addListener(final TemperatureIF listener);

    void removeListener(final TemperatureIF listener);
}
