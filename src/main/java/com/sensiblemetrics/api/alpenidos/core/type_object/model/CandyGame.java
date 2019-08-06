package com.sensiblemetrics.api.alpenidos.core.type_object.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * The CandyGame class contains the rules for the continuation of the game and has
 * the game matrix (field 'cells') and totalPoints gained during the game.
 */
@Slf4j
@Data
public class CandyGame {
    private Cell[][] cells;
    private CellPool pool;
    private int totalPoints;

    public CandyGame(final int num, final CellPool pool) {
        this.cells = new Cell[num][num];
        this.pool = pool;
        this.totalPoints = 0;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                this.cells[i][j] = this.pool.getNewCell();
                this.cells[i][j].setXIndex(j);
                this.cells[i][j].setYIndex(i);
            }
        }
    }

    static String numOfSpaces(final int num) {
        String result = "";
        for (int i = 0; i < num; i++) {
            result += " ";
        }
        return result;
    }

    public void printGameStatus() {
        for (int i = 0; i < this.cells.length; i++) {
            for (int j = 0; j < this.cells.length; j++) {
                final String candyName = cells[i][j].getCandy().getName();
                if (candyName.length() < 20) {
                    final int totalSpaces = 20 - candyName.length();
                    log.info(numOfSpaces(totalSpaces / 2) + cells[i][j].getCandy().getName() + numOfSpaces(totalSpaces - totalSpaces / 2) + "|");
                } else {
                    log.info(candyName + "|");
                }
            }
            log.info("\n");
        }
        log.info("\n");
    }

    public List<Cell> adjacentCells(int yIndex, int xIndex) {
        final List<Cell> adjacent = new ArrayList<>();
        if (yIndex == 0) {
            adjacent.add(this.cells[1][xIndex]);
        }
        if (xIndex == 0) {
            adjacent.add(this.cells[yIndex][1]);
        }
        if (yIndex == cells.length - 1) {
            adjacent.add(this.cells[cells.length - 2][xIndex]);
        }
        if (xIndex == cells.length - 1) {
            adjacent.add(this.cells[yIndex][cells.length - 2]);
        }
        if (yIndex > 0 && yIndex < cells.length - 1) {
            adjacent.add(this.cells[yIndex - 1][xIndex]);
            adjacent.add(this.cells[yIndex + 1][xIndex]);
        }
        if (xIndex > 0 && xIndex < cells.length - 1) {
            adjacent.add(this.cells[yIndex][xIndex - 1]);
            adjacent.add(this.cells[yIndex][xIndex + 1]);
        }
        return adjacent;
    }

    public boolean continueRound() {
        for (int i = 0; i < this.cells.length; i++) {
            if (this.cells[cells.length - 1][i].getCandy().getType().equals(Candy.Type.rewardFruit)) {
                return true;
            }
        }
        for (int i = 0; i < this.cells.length; i++) {
            for (int j = 0; j < this.cells.length; j++) {
                if (!this.cells[i][j].getCandy().getType().equals(Candy.Type.rewardFruit)) {
                    final List<Cell> adj = this.adjacentCells(i, j);
                    for (int a = 0; a < adj.size(); a++) {
                        if (this.cells[i][j].getCandy().getName().equals(adj.get(a).getCandy().getName())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public void handleChange(final int points) {
        log.info("+" + points + " points!");
        this.totalPoints += points;
        this.printGameStatus();
    }

    public void round(final int timeSoFar, final int totalTime) {
        final long start = System.currentTimeMillis();
        long end = System.currentTimeMillis();
        while (end - start + timeSoFar < totalTime && continueRound()) {
            for (int i = 0; i < this.cells.length; i++) {
                int points = 0;
                int j = this.cells.length - 1;
                while (this.cells[j][i].getCandy().getType().equals(Candy.Type.rewardFruit)) {
                    points = this.cells[j][i].getCandy().getPoints();
                    this.cells[j][i].crush(this.pool, this.cells);
                    handleChange(points);
                }
            }
            for (int i = 0; i < this.cells.length; i++) {
                int j = this.cells.length - 1;
                int points = 0;
                while (j > 0) {
                    points = this.cells[j][i].interact(this.cells[j - 1][i], this.pool, this.cells);
                    if (points != 0) {
                        handleChange(points);
                    } else {
                        j = j - 1;
                    }
                }
            }
            for (int i = 0; i < this.cells.length; i++) {
                int j = 0;
                int points = 0;
                while (j < cells.length - 1) {
                    points = this.cells[i][j].interact(this.cells[i][j + 1], this.pool, this.cells);
                    if (points != 0) {
                        handleChange(points);
                    } else {
                        j = j + 1;
                    }
                }
            }
            end = System.currentTimeMillis();
        }
    }
}
