package com.sensiblemetrics.api.alpenidos.core.type_object.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Cell object is what the game matrix is made of and contains the candy which is
 * to be crushed or collected as reward.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cell {
    private Candy candy;
    private int xIndex;
    private int yIndex;

    public void crush(final CellPool pool, final Cell[][] cellMatrix) {
        //take out from this position and put back in pool
        pool.addNewCell(this);
        this.fillThisSpace(pool, cellMatrix);
    }

    public void fillThisSpace(final CellPool pool, final Cell[][] cellMatrix) {
        for (int y = this.yIndex; y > 0; y--) {
            cellMatrix[y][this.xIndex] = cellMatrix[y - 1][this.xIndex];
            cellMatrix[y][this.xIndex].yIndex = y;
        }
        final Cell newC = pool.getNewCell();
        cellMatrix[0][this.xIndex] = newC;
        cellMatrix[0][this.xIndex].xIndex = this.xIndex;
        cellMatrix[0][this.xIndex].yIndex = 0;
    }

    public void handleCrush(final Cell c, final CellPool pool, final Cell[][] cellMatrix) {
        if (this.yIndex >= c.yIndex) {
            this.crush(pool, cellMatrix);
            c.crush(pool, cellMatrix);
        } else {
            c.crush(pool, cellMatrix);
            this.crush(pool, cellMatrix);
        }
    }

    public int interact(final Cell c, final CellPool pool, final Cell[][] cellMatrix) {
        if (this.candy.getType().equals(Candy.Type.rewardFruit) || c.candy.getType().equals(Candy.Type.rewardFruit)) {
            return 0;
        }
        if (this.candy.getName().equals(c.candy.getName())) {
            final int pointsWon = this.candy.getPoints() + c.candy.getPoints();
            this.handleCrush(c, pool, cellMatrix);
            return pointsWon;
        }
        return 0;
    }
}
