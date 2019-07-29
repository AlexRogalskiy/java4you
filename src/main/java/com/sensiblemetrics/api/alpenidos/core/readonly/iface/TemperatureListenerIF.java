package com.sensiblemetrics.api.alpenidos.core.readonly.iface;

import com.sensiblemetrics.api.alpenidos.core.readonly.impl.TemperatureEvent;

public interface TemperatureListenerIF extends TemperatureIF {

    void temperatureChanged(final TemperatureEvent event);
}
