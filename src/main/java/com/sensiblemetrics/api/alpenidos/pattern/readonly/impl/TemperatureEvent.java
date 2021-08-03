package com.sensiblemetrics.api.alpenidos.pattern.readonly.impl;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TemperatureEvent {
    private final TemperatureData temperatureData;
    private final double temperature;
}
