package com.sensiblemetrics.api.alpenidos.core.bridge2.impl;

import com.sensiblemetrics.api.alpenidos.core.bridge2.exception.SensorException;
import com.sensiblemetrics.api.alpenidos.core.bridge2.iface.SimpleSensorIF;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SimpleSensor {
    private final SimpleSensorIF sensorIF;

    public int getValue() throws SensorException {
        return this.sensorIF.getValue();
    }
}
