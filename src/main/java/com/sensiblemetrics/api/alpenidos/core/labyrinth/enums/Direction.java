package com.sensiblemetrics.api.alpenidos.core.labyrinth.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum allowing to handle two-axis directions
 */
@Getter
@RequiredArgsConstructor
public enum Direction {
    NORTH("N"),
    SOUTH("S"),
    EAST("E"),
    WEST("W");

    private final String value;

    public Direction getResultingDirectionAfterLeftTurn() {
        switch (this) {
            case NORTH:
                return WEST;
            case SOUTH:
                return EAST;
            case EAST:
                return NORTH;
            case WEST:
            default:
                return SOUTH;
        }
    }

    public Direction getResultingDirectionAfterRightTurn() {
        switch (this) {
            case NORTH:
                return EAST;
            case SOUTH:
                return WEST;
            case EAST:
                return SOUTH;
            case WEST:
            default:
                return NORTH;
        }
    }

    public Direction getResultingDirectionAfterUTurn() {
        switch (this) {
            case NORTH:
                return SOUTH;
            case SOUTH:
                return NORTH;
            case EAST:
                return WEST;
            case WEST:
            default:
                return EAST;
        }
    }
}
