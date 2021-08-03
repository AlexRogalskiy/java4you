package com.sensiblemetrics.api.alpenidos.pattern.labyrinth.model;

import com.sensiblemetrics.api.alpenidos.pattern.labyrinth.enums.Action;
import com.sensiblemetrics.api.alpenidos.pattern.labyrinth.enums.Direction;
import lombok.Data;

/**
 * Class representing a turn of labyrinth game (turn number, starting position,
 * moving direction, resulting position)
 */
@Data
public class TurnInfo {
    private final int turnNumber;
    private final Position startingPosition;
    private final Direction startingDirection;
    private final Action action;
    private final Position resultingPosition;
    private final Direction resultingDirection;

    /**
     * Constructs a new TurnInfo instance, with given turn number, starting
     * position and direction, action and resulting position and direction
     */
    public TurnInfo(int turnNumber, Position startingPosition, Direction startingDirection, Action action, Position resultingPosition, Direction resultingDirection) {
        this.turnNumber = turnNumber;
        this.startingPosition = startingPosition;
        this.startingDirection = startingDirection;
        this.action = action;
        this.resultingPosition = resultingPosition;
        this.resultingDirection = resultingDirection;
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Robot starts turn " + this.turnNumber + " at " + this.startingPosition + ", heading " + this.startingDirection + "\n");
        sb.append("Robot action is " + this.action + "\n");
        sb.append("Robot ends turn " + this.turnNumber + " at " + this.resultingPosition + ", heading " + this.resultingDirection + "\n");
        return sb.toString();
    }
}
