package com.sensiblemetrics.api.alpenidos.pattern.twin.factory;

import com.sensiblemetrics.api.alpenidos.pattern.twin.model.BallItem;
import lombok.extern.slf4j.Slf4j;

/**
 * This class is a UI thread for drawing the {@link BallItem}, and provide the method for suspend
 * and resume. It hold the reference of {@link BallItem} to delegate the draw task.
 */
@Slf4j
public class BallThread extends Thread {
    private BallItem twin;

    private volatile boolean isSuspended;
    private volatile boolean isRunning = true;

    public void setTwin(final BallItem twin) {
        this.twin = twin;
    }

    /**
     * Run the thread
     */
    public void run() {
        while (this.isRunning) {
            if (!this.isSuspended) {
                this.twin.draw();
                this.twin.move();
            }
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void suspendMe() {
        this.isSuspended = true;
        log.info("Begin to suspend BallThread");
    }

    public void resumeMe() {
        this.isSuspended = false;
        log.info("Begin to resume BallThread");
    }

    public void stopMe() {
        this.isRunning = false;
        this.isSuspended = true;
    }
}

