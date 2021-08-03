package com.sensiblemetrics.api.alpenidos.pattern.bridge2.iface;

import com.sensiblemetrics.api.alpenidos.pattern.bridge2.exception.SensorException;

public interface SimpleSensorIF {

    int getValue() throws SensorException;
}
