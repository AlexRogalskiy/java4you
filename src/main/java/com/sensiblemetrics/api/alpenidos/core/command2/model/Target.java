package com.sensiblemetrics.api.alpenidos.core.command2.model;

import com.sensiblemetrics.api.alpenidos.core.command2.enums.Size;
import com.sensiblemetrics.api.alpenidos.core.command2.enums.Visibility;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * Base class for spell targets.
 */
@Slf4j
@Data
public abstract class Target {
    private Size size;
    private Visibility visibility;

    @Override
    public abstract String toString();

    /**
     * Print status
     */
    public void printStatus() {
        log.info("{}, [size={}] [visibility={}]", this, this.getSize(), this.getVisibility());
    }
}
