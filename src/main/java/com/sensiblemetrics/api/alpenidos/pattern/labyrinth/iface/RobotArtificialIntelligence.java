package com.sensiblemetrics.api.alpenidos.pattern.labyrinth.iface;

import com.sensiblemetrics.api.alpenidos.pattern.labyrinth.enums.Action;

public interface RobotArtificialIntelligence {
    /**
     * callback method used to get the action the robot wish to perform
     */
    Action getAction();

    /**
     * callback method used to notify scan result (if robot last action type was SCAN)
     */
    void notifyScanResult(final int distancesToWallsInEachDirection);

    /**
     * callback method used  to notify move result (if robot last action type was MOVE_FORWARD)
     */
    void notifyMoveResult(final boolean hasMoved);
}
