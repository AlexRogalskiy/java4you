package com.sensiblemetrics.api.alpenidos.pattern.facade.controller;

import com.sensiblemetrics.api.alpenidos.pattern.facade.model.AirFlowMeter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AirFlowController {
    private final AirFlowMeter airFlowMeter = new AirFlowMeter();

    public void takeAir() {
        this.airFlowMeter.getMeasurements();
        log.info("Air provided!");
    }

    public void off() {
        log.info("Air controller switched off.");
    }
}
