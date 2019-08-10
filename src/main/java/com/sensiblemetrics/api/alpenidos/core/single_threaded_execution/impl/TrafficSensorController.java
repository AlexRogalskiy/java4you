package com.sensiblemetrics.api.alpenidos.core.single_threaded_execution.impl;

import com.sensiblemetrics.api.alpenidos.core.single_threaded_execution.iface.TrafficObserver;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * <p>
 * Date: Aug 18, 2011
 *
 * @author moleksyuk
 */
public class TrafficSensorController implements TrafficObserver {
    private int vehicleCount = 0;

    public synchronized int getAndClearCount() {
        int count = this.vehicleCount;
        this.vehicleCount = 0;
        return count;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.moleksyuk.chapter9.SingleThreadedExecution.TrafficSensor.TrafficObserver
     * #vehiclePassed()
     */
    @Override
    public synchronized void vehiclePassed() {
        this.vehicleCount++;
    }
}
