package com.sensiblemetrics.api.alpenidos.core.front_controller.view;

import com.sensiblemetrics.api.alpenidos.core.front_controller.view.View;
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
