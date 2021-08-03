package com.sensiblemetrics.api.alpenidos.pattern.labyrinth.model;

import com.sensiblemetrics.api.alpenidos.pattern.labyrinth.enums.Direction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Class representing a position in a two-axis coordinate system
 */
@Data
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Position {
    private final int x;
    private final int y;

    public Position getNeighbourPosition(final Direction direction) {
        switch (direction) {
            case NORTH:
                return new Position(this.x, this.y - 1);
            case SOUTH:
                return new Position(this.x, this.y + 1);
            case EAST:
                return new Position(this.x + 1, this.y);
            case WEST:
            default:
                return new Position(this.x - 1, this.y);
        }
    }
}
