package com.sensiblemetrics.api.alpenidos.pattern.mvc.view;

import com.sensiblemetrics.api.alpenidos.pattern.mvc.model.GiantModel;
import lombok.extern.slf4j.Slf4j;

/**
 * GiantView displays the giant
 */
@Slf4j
public class GiantView {

    public void displayGiant(final GiantModel giant) {
        log.info(giant.toString());
    }
}
