package com.sensiblemetrics.api.alpenidos.core.throttling.impl;

import com.sensiblemetrics.api.alpenidos.core.throttling.iface.Throttler;
import com.sensiblemetrics.api.alpenidos.core.throttling.model.CallsCount;
import lombok.RequiredArgsConstructor;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Implementation of throttler interface. This class resets the counter every second.
 */
@RequiredArgsConstructor
public class ThrottleTimerImpl implements Throttler {
    private final int throttlePeriod;
    private final CallsCount callsCount;

    /**
     * A timer is initiated with this method. The timer runs every second and resets the
     * counter.
     */
    public void start() {
        new Timer(true).schedule(new TimerTask() {
            @Override
            public void run() {
                callsCount.reset();
            }
        }, 0, this.throttlePeriod);
    }
}
