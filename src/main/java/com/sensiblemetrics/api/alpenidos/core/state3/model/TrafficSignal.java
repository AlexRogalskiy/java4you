package com.sensiblemetrics.api.alpenidos.core.state3.model;

import com.sensiblemetrics.api.alpenidos.core.state3.iface.TrafficSignalContext;
import com.sensiblemetrics.api.alpenidos.core.state3.iface.TrafficSignalUserInterface;
import com.sensiblemetrics.api.alpenidos.core.state3.impl.TrafficSignalGreenState;
import com.sensiblemetrics.api.alpenidos.core.state3.impl.TrafficSignalState;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TrafficSignal extends Thread implements TrafficSignalContext, TrafficSignalUserInterface {
    private TrafficSignalState state;

    @Override
    public void setTrafficSignalState(final TrafficSignalState state) {
        log.info("Traffic signal state is " + state.getName());
        this.state = state;
    }

    @Override
    public void pressButton() {
        this.state.buttonPressed();
    }

    public void run() {
        this.setTrafficSignalState(new TrafficSignalGreenState(this));
        while (true) {
            try {
                Thread.sleep(1000);
                this.state.secondEllapsed();
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
