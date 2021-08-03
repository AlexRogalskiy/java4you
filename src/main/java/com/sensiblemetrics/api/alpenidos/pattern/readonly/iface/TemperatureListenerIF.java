package com.sensiblemetrics.api.alpenidos.pattern.readonly.iface;

import com.sensiblemetrics.api.alpenidos.pattern.readonly.impl.TemperatureEvent;

public interface TemperatureListenerIF extends TemperatureIF {

    void temperatureChanged(final TemperatureEvent event);
}
