package com.sensiblemetrics.api.alpenidos.pattern.labyrinth.impl;

import com.sensiblemetrics.api.alpenidos.pattern.labyrinth.enums.Action;
import com.sensiblemetrics.api.alpenidos.pattern.labyrinth.iface.RobotArtificialIntelligence;

public class DumbBotArtificialIntelligence implements RobotArtificialIntelligence {
    private boolean isBlocked;

    public DumbBotArtificialIntelligence() {
        this.isBlocked = false;
    }

    @Override
    public Action getAction() {
        if (this.isBlocked) {
            this.isBlocked = false;
            return Action.TURN_LEFT;
        }
        return Action.MOVE_FORWARD;
    }

    @Override
    public void notifyScanResult(final int distancesToWallsInEachDirection) {
    }

    @Override
    public void notifyMoveResult(final boolean hasMoved) {
        this.isBlocked = !hasMoved;
    }
}
