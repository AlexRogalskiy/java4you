package com.sensiblemetrics.api.alpenidos.pattern.type_object;

import com.sensiblemetrics.api.alpenidos.pattern.type_object.model.Candy;
import com.sensiblemetrics.api.alpenidos.pattern.type_object.model.CandyGame;
import com.sensiblemetrics.api.alpenidos.pattern.type_object.model.Cell;
import com.sensiblemetrics.api.alpenidos.pattern.type_object.model.CellPool;
import com.sensiblemetrics.api.alpenidos.pattern.type_object.parser.JsonParser;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * <p>Type object pattern is the pattern we use when the OOP concept of creating a base class and
 * inheriting from it just doesn't work for the case in hand. This happens when we either don't know
 * what types we will need upfront, or want to be able to modify or add new types conveniently w/o
 * recompiling repeatedly. The pattern provides a solution by allowing flexible creation of required
 * objects by creating one class, which has a field which represents the 'type' of the object.</p>
 * <p>In this example, we have a mini candy-crush game in action. There are many different candies
 * in the game, which may change over time, as we may want to upgrade the game. To make the object
 * creation convenient, we have a class {@link Candy} which has a field name, parent, points and
 * Type. We have a json file which contains the details about the candies, and this is
 * parsed to get all the different candies in {@link JsonParser}. The {@link Cell} class is what the
 * game matrix is made of, which has the candies that are to be crushed, and contains information on
 * how crushing can be done, how the matrix is to be reconfigured and how points are to be gained.
 * The {@link CellPool} class is a pool which reuses the candy cells that have been crushed instead
 * of making new ones repeatedly. The {@link CandyGame} class has the rules for the continuation of
 * the game and the {@link TypeObjectPatternLoader} class has the game itself.</p>
 */
@Slf4j
public class TypeObjectPatternLoader {

    /**
     * Program entry point.
     *
     * @param args command line args
     */
    public static void main(final String[] args) throws FileNotFoundException, IOException, ParseException {
        int givenTime = 50; //50ms
        int toWin = 500; //points
        int pointsWon = 0;
        int numOfRows = 3;
        long start = System.currentTimeMillis();
        long end = System.currentTimeMillis();
        int round = 0;

        while (pointsWon < toWin && end - start < givenTime) {
            round++;
            final CellPool pool = new CellPool(numOfRows * numOfRows + 5);
            final CandyGame cg = new CandyGame(numOfRows, pool);
            if (round > 1) {
                log.info("Refreshing..");
            } else {
                log.info("Starting game..");
            }
            cg.printGameStatus();
            end = System.currentTimeMillis();
            cg.round((int) (end - start), givenTime);
            pointsWon += cg.getTotalPoints();
            end = System.currentTimeMillis();
        }
        log.info("Game Over");
        if (pointsWon >= toWin) {
            log.info(String.valueOf(pointsWon));
            log.info("You win!!");
        } else {
            log.info(String.valueOf(pointsWon));
            log.info("Sorry, you lose!");
        }
    }
}
