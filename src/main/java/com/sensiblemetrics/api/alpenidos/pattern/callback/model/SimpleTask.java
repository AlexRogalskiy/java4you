package com.sensiblemetrics.api.alpenidos.pattern.callback.model;

import lombok.extern.slf4j.Slf4j;

/**
 * Implementation of task that need to be executed
 */
@Slf4j
public class SimpleTask extends Task {

    @Override
    public void execute() {
        log.info("Perform some important activity and after call the callback method.");
    }
}
