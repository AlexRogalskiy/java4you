package com.sensiblemetrics.api.alpenidos.core.front_controller.view;

import com.sensiblemetrics.api.alpenidos.core.front_controller.view.View;
import lombok.extern.slf4j.Slf4j;

/**
 * View for catapults.
 */
@Slf4j
public class CatapultView implements View {

    @Override
    public void display() {
        log.info("Displaying catapults");
    }
}
