package com.sensiblemetrics.api.alpenidos.pattern.twin.model;

import com.sensiblemetrics.api.alpenidos.pattern.twin.factory.BallThread;
import lombok.extern.slf4j.Slf4j;

/**
 * This class represents a Ball which extends {@link GameItem} and implements the logic for ball
 * item, like move and draw. It hold a reference of {@link BallThread} to delegate the suspend and
 * resume task.
 */
@Slf4j
public class BallItem extends GameItem {
    private boolean isSuspended;
    private BallThread twin;

    public void setTwin(final BallThread twin) {
        this.twin = twin;
    }

    @Override
    public void doDraw() {
        log.info("doDraw");
    }

    public void move() {
        log.info("move");
    }

    @Override
    public void click() {
        this.isSuspended = !this.isSuspended;
        if (this.isSuspended) {
            this.twin.suspendMe();
        } else {
            this.twin.resumeMe();
        }
    }
}
