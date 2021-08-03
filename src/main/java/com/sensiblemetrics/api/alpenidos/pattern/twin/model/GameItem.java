package com.sensiblemetrics.api.alpenidos.pattern.twin.model;

import lombok.extern.slf4j.Slf4j;

/**
 * GameItem is a common class which provides some common methods for game object.
 */
@Slf4j
public abstract class GameItem {

    /**
     * Template method, do some common logic before draw
     */
    public void draw() {
        log.info("draw");
        this.doDraw();
    }

    public abstract void doDraw();

    public abstract void click();
}
