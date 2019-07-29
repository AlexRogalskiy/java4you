package com.sensiblemetrics.api.alpenidos.core.bridge2.iface;

import com.sensiblemetrics.api.alpenidos.core.bridge2.SensorException;

public interface StreamingSensorIF extends SimpleSensorIF {

    void setSamplingFrequency(final int value) throws SensorException;

    void setStreamingSensorListener(final StreamingSensorListener listener);
}
