package com.sensiblemetrics.api.alpenidos.core.facade.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FuelInjector {

    private final FuelPump fuelPump = new FuelPump();

    public void on() {
        log.info("Fuel injector ready to inject fuel.");
    }

    public void inject() {
        this.fuelPump.pump();
        log.info("Fuel injected.");
    }

    public void off() {
        log.info("Stopping Fuel injector..");
    }
}
