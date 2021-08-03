package com.sensiblemetrics.api.alpenidos.pattern.labyrinth.model;

import com.sensiblemetrics.api.alpenidos.pattern.labyrinth.enums.Action;
import com.sensiblemetrics.api.alpenidos.pattern.labyrinth.enums.CellState;
import com.sensiblemetrics.api.alpenidos.pattern.labyrinth.enums.Direction;
import com.sensiblemetrics.api.alpenidos.pattern.labyrinth.iface.RobotArtificialIntelligence;
import lombok.extern.slf4j.Slf4j;

/**
 * Class representing a game of "escape labyrinth if you can"
 */
@Slf4j
public class LabyrinthGame {
    private final Labyrinth labyrinth;
    private final RobotArtificialIntelligence robotAI;

    private Position robotPosition;
    private Direction robotDirection;
    private int turnNumber;

    public LabyrinthGame(final Labyrinth labyrinth, final RobotArtificialIntelligence robotAI) {
        this.labyrinth = labyrinth;
        this.robotAI = robotAI;
        this.robotPosition = this.labyrinth.getStartingPosition();
        this.robotDirection = Direction.NORTH;
        this.turnNumber = 1;
    }

    public void play() {
        loopUntilRobotHasReachedExit();
        log.info("Robot has reached the exit in " + this.turnNumber + " turns");
    }

    private void loopUntilRobotHasReachedExit() {
        while (true) {
            if (this.hasRobotReachedExit()) {
                break;
            }
            this.processRobotAction();
            this.turnNumber += 1;
        }
    }

    private void processRobotAction() {
        final Action action = this.robotAI.getAction();
        final Position oldRobotPosition = this.robotPosition;
        final Direction oldRobotDirection = this.robotDirection;

        switch (action) {
            case MOVE_FORWARD:
                this.processMoveForwardAction();
                break;
            case TURN_LEFT:
                this.processTurnLeftAction();
                break;
            case TURN_RIGHT:
                this.processTurnRightAction();
                break;
            case U_TURN:
                this.processUTurnAction();
                break;
            case SCAN:
            default:
                this.processScanAction();
                break;
        }

        System.out.println(new TurnInfo(turnNumber, oldRobotPosition, oldRobotDirection, action, this.robotPosition, this.robotDirection));
    }

    private void processScanAction() {
    }

    private void processUTurnAction() {
        this.robotDirection = this.robotDirection.getResultingDirectionAfterUTurn();
    }

    private void processTurnRightAction() {
        this.robotDirection = this.robotDirection.getResultingDirectionAfterRightTurn();
    }

    private void processTurnLeftAction() {
        this.robotDirection = this.robotDirection.getResultingDirectionAfterLeftTurn();
    }

    private void processMoveForwardAction() {
        final Position resultingPosition = this.labyrinth.getResultingPositionWhenMoving(this.robotPosition, this.robotDirection);
        final boolean hasMoved = !(resultingPosition.equals(this.robotPosition));
        this.robotPosition = resultingPosition;
        this.robotAI.notifyMoveResult(hasMoved);
    }

    private boolean hasRobotReachedExit() {
        return this.labyrinth.getCellStateAt(this.robotPosition) == CellState.EXIT;
    }
}
