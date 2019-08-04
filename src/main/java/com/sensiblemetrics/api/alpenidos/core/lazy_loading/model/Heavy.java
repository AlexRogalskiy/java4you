package com.sensiblemetrics.api.alpenidos.core.lazy_loading.model;

import lombok.extern.slf4j.Slf4j;

/**
 * Heavy objects are expensive to create.
 */
@Slf4j
public class Heavy {

    /**
     * Constructor
     */
    public Heavy() {
        log.info("Creating Heavy ...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error("Exception caught.", e);
        }
        log.info("... Heavy created");
    }
}
