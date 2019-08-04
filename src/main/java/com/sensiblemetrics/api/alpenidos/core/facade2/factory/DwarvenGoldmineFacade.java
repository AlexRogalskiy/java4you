package com.sensiblemetrics.api.alpenidos.core.facade2.factory;

import com.sensiblemetrics.api.alpenidos.core.facade2.impl.DwarvenCartOperator;
import com.sensiblemetrics.api.alpenidos.core.facade2.impl.DwarvenGoldDigger;
import com.sensiblemetrics.api.alpenidos.core.facade2.impl.DwarvenMineWorker;
import com.sensiblemetrics.api.alpenidos.core.facade2.impl.DwarvenTunnelDigger;

import java.util.*;

/**
 * DwarvenGoldmineFacade provides a single interface through which users can operate the subsystems.
 * <p>
 * This makes the goldmine easier to operate and cuts the dependencies from the goldmine user to the
 * subsystems.
 */
public class DwarvenGoldmineFacade {
    private final List<DwarvenMineWorker> workers;

    /**
     * Constructor
     */
    public DwarvenGoldmineFacade() {
        this.workers = new ArrayList<>();
        this.workers.add(new DwarvenGoldDigger());
        this.workers.add(new DwarvenCartOperator());
        this.workers.add(new DwarvenTunnelDigger());
    }

    public void startNewDay() {
        makeActions(this.workers, DwarvenMineWorker.Action.WAKE_UP, DwarvenMineWorker.Action.GO_TO_MINE);
    }

    public void digOutGold() {
        makeActions(this.workers, DwarvenMineWorker.Action.WORK);
    }

    public void endDay() {
        makeActions(this.workers, DwarvenMineWorker.Action.GO_HOME, DwarvenMineWorker.Action.GO_TO_SLEEP);
    }

    private static void makeActions(final Collection<DwarvenMineWorker> workers, final DwarvenMineWorker.Action... actions) {
        Optional.ofNullable(workers).orElseGet(Collections::emptyList).forEach(w -> w.action(actions));
    }
}
