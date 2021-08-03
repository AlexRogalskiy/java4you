package com.sensiblemetrics.api.alpenidos.pattern.front_controller.view;

import lombok.extern.slf4j.Slf4j;

/**
 * View for archers.
 */
@Slf4j
public class ArcherView implements View {

    @Override
    public void display() {
        log.info("Displaying archers");
    }
}
