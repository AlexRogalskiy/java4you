package com.sensiblemetrics.api.alpenidos.pattern.facade.controller;

import com.sensiblemetrics.api.alpenidos.pattern.facade.model.Radiator;
import com.sensiblemetrics.api.alpenidos.pattern.facade.model.TemperatureSensor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CoolingController {
    private static final Integer DEFAULT_RADIATOR_SPEED = 10;

    private Integer temperatureUpperLimit;
    private final Radiator radiator = new Radiator();
    private final TemperatureSensor temperatureSensor = new TemperatureSensor();

    public void setTemperatureUpperLimit(final Integer temperatureUpperLimit) {
        log.info("Setting temperature upper limit to {}", temperatureUpperLimit);
        this.temperatureUpperLimit = temperatureUpperLimit;
    }

    public void run() {
        log.info("Cooling Controller ready!");
        this.radiator.setSpeed(DEFAULT_RADIATOR_SPEED);
    }

    public void cool(final Integer maxAllowedTemp) {
        log.info("Scheduled cooling with maximum allowed temperature {}", maxAllowedTemp);
        this.temperatureSensor.getTemperature();
        this.radiator.on();
    }

    public void stop() {
        log.info("Stopping Cooling Controller..");
        this.radiator.off();
    }
}
