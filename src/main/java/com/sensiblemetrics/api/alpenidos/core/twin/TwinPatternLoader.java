package com.sensiblemetrics.api.alpenidos.core.twin;

import com.sensiblemetrics.api.alpenidos.core.twin.factory.BallThread;
import com.sensiblemetrics.api.alpenidos.core.twin.model.BallItem;
import com.sensiblemetrics.api.alpenidos.core.twin.model.GameItem;

/**
 * Twin pattern is a design pattern which provides a standard solution to simulate multiple
 * inheritance in java.
 * <p>
 * In this example, the essence of the Twin pattern is the {@link BallItem} class and
 * {@link BallThread} class represent the twin objects to coordinate with each other(via the twin
 * reference) like a single class inheriting from {@link GameItem} and {@link Thread}.
 */

public class TwinPatternLoader {

    /**
     * Program entry point
     *
     * @param args command line args
     */
    public static void main(final String[] args) throws Exception {
        final BallItem ballItem = new BallItem();
        final BallThread ballThread = new BallThread();

        ballItem.setTwin(ballThread);
        ballThread.setTwin(ballItem);
        ballThread.start();

        waiting();
        ballItem.click();

        waiting();
        ballItem.click();

        waiting();
        // exit
        ballThread.stopMe();
    }

    private static void waiting() throws Exception {
        Thread.sleep(750);
    }
}
