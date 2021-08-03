package com.sensiblemetrics.api.alpenidos.pattern.readonly.iface;

public interface TemperatureIF {

    double getTemperature();

    void addListener(final TemperatureListenerIF listener);

    void removeListener(final TemperatureListenerIF listener);
}
