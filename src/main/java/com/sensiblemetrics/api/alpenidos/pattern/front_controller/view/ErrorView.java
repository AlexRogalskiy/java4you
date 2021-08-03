package com.sensiblemetrics.api.alpenidos.pattern.front_controller.view;

import lombok.extern.slf4j.Slf4j;

/**
 * View for errors.
 */
@Slf4j
public class ErrorView implements View {

    @Override
    public void display() {
        log.error("Error 500");
    }
}
