package com.sensiblemetrics.api.alpenidos.core.facade2.impl;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * DwarvenMineWorker is one of the goldmine subsystems.
 */
@Slf4j
public abstract class DwarvenMineWorker {

    public void goToSleep() {
        log.info("{} goes to sleep.", name());
    }

    public void wakeUp() {
        log.info("{} wakes up.", name());
    }

    public void goHome() {
        log.info("{} goes home.", name());
    }

    public void goToMine() {
        log.info("{} goes to the mine.", name());
    }

    private void action(final Action action) {
        switch (action) {
            case GO_TO_SLEEP:
                this.goToSleep();
                break;
            case WAKE_UP:
                this.wakeUp();
                break;
            case GO_HOME:
                this.goHome();
                break;
            case GO_TO_MINE:
                this.goToMine();
                break;
            case WORK:
                this.work();
                break;
            default:
                log.info("Undefined action");
                break;
        }
    }

    /**
     * Perform actions
     */
    public void action(final Action... actions) {
        Arrays.stream(actions).forEach(this::action);
    }

    public abstract void work();

    public abstract String name();

    public enum Action {
        GO_TO_SLEEP,
        WAKE_UP,
        GO_HOME,
        GO_TO_MINE,
        WORK
    }
}
