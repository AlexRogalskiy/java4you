package com.sensiblemetrics.api.alpenidos.core.balking.impl;

import com.sensiblemetrics.api.alpenidos.core.balking.enums.WashingMachineState;
import com.sensiblemetrics.api.alpenidos.core.balking.iface.DelayProvider;
import com.sensiblemetrics.api.alpenidos.core.balking.iface.WashingMachineIF;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * Washing machine class
 */
@Slf4j
@Data
public class WashingMachine implements WashingMachineIF {
    private final DelayProvider delayProvider;
    private WashingMachineState washingMachineState;

    /**
     * Creates a new instance of WashingMachine
     */
    public WashingMachine() {
        this((interval, timeUnit, task) -> {
            try {
                Thread.sleep(timeUnit.toMillis(interval));
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
            task.run();
        });
    }

    /**
     * Creates a new instance of WashingMachine using provided delayProvider. This constructor is used only for
     * unit testing purposes.
     */
    public WashingMachine(final DelayProvider delayProvider) {
        this.delayProvider = delayProvider;
        this.washingMachineState = WashingMachineState.ENABLED;
    }

    /**
     * Method responsible for washing
     * if the object is in appropriate state
     */
    @Override
    public void wash() {
        synchronized (this) {
            log.info("{}: Actual machine state: {}", Thread.currentThread().getName(), getWashingMachineState());
            if (this.washingMachineState == WashingMachineState.WASHING) {
                log.error("ERROR: Cannot wash if the machine has been already washing!");
                return;
            }
            this.washingMachineState = WashingMachineState.WASHING;
        }
        log.info("{}: Doing the washing", Thread.currentThread().getName());
        this.delayProvider.executeAfterDelay(50, TimeUnit.MILLISECONDS, this::endOfWashing);
    }

    /**
     * Method responsible of ending the washing
     * by changing machine state
     */
    public synchronized void endOfWashing() {
        this.washingMachineState = WashingMachineState.ENABLED;
        log.info("{}: Washing completed.", Thread.currentThread().getId());
    }
}
