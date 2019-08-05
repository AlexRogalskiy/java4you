package com.sensiblemetrics.api.alpenidos.core.res_acq_is_init.model;

import lombok.extern.slf4j.Slf4j;

/**
 * SlidingDoor resource
 */
@Slf4j
public class SlidingDoor implements AutoCloseable {

    public SlidingDoor() {
        log.info("Sliding door opens.");
    }

    @Override
    public void close() {
        log.info("Sliding door closes.");
    }
}
