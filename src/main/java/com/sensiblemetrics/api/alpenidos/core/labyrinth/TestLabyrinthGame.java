package com.sensiblemetrics.api.alpenidos.core.labyrinth;

import com.google.common.collect.ImmutableSet;
import com.sensiblemetrics.api.alpenidos.core.labyrinth.impl.DumbBotArtificialIntelligence;
import com.sensiblemetrics.api.alpenidos.core.labyrinth.impl.LesserDumbBotArtificialIntelligence;
import com.sensiblemetrics.api.alpenidos.core.labyrinth.model.Labyrinth;
import com.sensiblemetrics.api.alpenidos.core.labyrinth.model.LabyrinthGame;
import com.sensiblemetrics.api.alpenidos.core.labyrinth.model.Position;

import java.util.Set;

/**
 * Test application for labyrinth game
 */
public class TestLabyrinthGame {
    /**
     * Application's main
     *
     * @param args command-line arguments (none expected here)
     */
    public static void main(final String[] args) {
        final int width = 4;
        final int height = 4;

        final Set<Position> blockPositions = ImmutableSet.<Position>builder()
            .add(new Position(2, 0))
            .add(new Position(3, 0))
            .add(new Position(0, 1))
            .add(new Position(0, 2))
            .add(new Position(1, 2))
            .add(new Position(3, 2))
            .add(new Position(3, 3))
            .build();

        new LabyrinthGame(new Labyrinth(width, height, blockPositions, new Position(3, 1)), new LesserDumbBotArtificialIntelligence()).play();
        new LabyrinthGame(new Labyrinth(width, height, blockPositions, new Position(3, 1)), new DumbBotArtificialIntelligence()).play();
    }
}
