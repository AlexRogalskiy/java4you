package com.sensiblemetrics.api.alpenidos.core.single_threaded_execution.factory;

import com.sensiblemetrics.api.alpenidos.core.single_threaded_execution.iface.TrafficObserver;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * <p>
 * Date: Aug 18, 2011
 *
 * @author moleksyuk
 */
public class TrafficSensor implements Runnable {
    private TrafficObserver observer;

    public TrafficSensor(final TrafficObserver observer) {
        this.observer = observer;
        new Thread(this).start();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        this.monitorSensor();
    }

    private native void monitorSensor();

    private void detect() {
        this.observer.vehiclePassed();
    }
}
