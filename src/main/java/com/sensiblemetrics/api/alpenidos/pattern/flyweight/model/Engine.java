package com.sensiblemetrics.api.alpenidos.pattern.flyweight.model;

import lombok.extern.slf4j.Slf4j;

/**
 * Engine for a vehicle.
 *
 * @author Donato Rimenti
 */
@Slf4j
public class Engine {
    /**
     * Starts the engine.
     */
    public void start() {
        log.info("Engine is starting!");
    }

    /**
     * Stops the engine.
     */
    public void stop() {
        log.info("Engine is stopping!");
    }
}
