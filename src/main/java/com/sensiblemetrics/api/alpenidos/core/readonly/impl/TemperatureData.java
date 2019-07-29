package com.sensiblemetrics.api.alpenidos.core.readonly.impl;

import com.sensiblemetrics.api.alpenidos.core.readonly.iface.TemperatureIF;
import com.sensiblemetrics.api.alpenidos.core.readonly.iface.TemperatureListenerIF;

import java.util.ArrayList;
import java.util.List;

public class TemperatureData implements TemperatureIF {
    private double temperature;
    private List<TemperatureIF> listeners = new ArrayList<>();

    public void setTemperature(final double temperature) {
        this.temperature = temperature;
        this.fireTemperature();
    }

    @Override
    public double getTemperature() {
        return this.temperature;
    }

    @Override
    public void addListener(final TemperatureIF listener) {
        this.listeners.add(listener);
    }

    @Override
    public void removeListener(final TemperatureIF listener) {
        this.listeners.remove(listener);
    }

    private void fireTemperature() {
        final int count = this.listeners.size();
        final TemperatureEvent event = new TemperatureEvent(this, temperature);
        this.listeners.stream().map(l -> (TemperatureListenerIF) l).forEach(l -> l.temperatureChanged(event));
    }
}
