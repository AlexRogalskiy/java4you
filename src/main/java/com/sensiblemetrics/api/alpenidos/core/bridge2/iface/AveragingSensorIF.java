package com.sensiblemetrics.api.alpenidos.core.bridge2.iface;

import com.sensiblemetrics.api.alpenidos.core.bridge2.exception.SensorException;

public interface AveragingSensorIF extends SimpleSensorIF {

    void beginAverage() throws SensorException;
}
