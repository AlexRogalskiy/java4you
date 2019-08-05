package com.sensiblemetrics.api.alpenidos.core.object_mother;

import com.sensiblemetrics.api.alpenidos.core.object_mother.impl.King;
import com.sensiblemetrics.api.alpenidos.core.object_mother.impl.Queen;

/**
 * Object Mother Pattern generating Royalty Types
 */
public final class RoyaltyObjectMother {

    /**
     * Method to create a sober and unhappy king. The standard parameters are set.
     *
     * @return An instance of {@link King} with the standard properties.
     */
    public static King createSoberUnhappyKing() {
        return new King();
    }

    /**
     * Method of the object mother to create a drunk king.
     *
     * @return A drunk {@link King}.
     */
    public static King createDrunkKing() {
        final King king = new King();
        king.makeDrunk();
        return king;
    }

    /**
     * Method to create a happy king.
     *
     * @return A happy {@link King}.
     */
    public static King createHappyKing() {
        final King king = new King();
        king.makeHappy();
        return king;
    }

    /**
     * Method to create a happy and drunk king.
     *
     * @return A drunk and happy {@link King}.
     */
    public static King createHappyDrunkKing() {
        final King king = new King();
        king.makeHappy();
        king.makeDrunk();
        return king;
    }

    /**
     * Method to create a flirty queen.
     *
     * @return A flirty {@link Queen}.
     */
    public static Queen createFlirtyQueen() {
        final Queen queen = new Queen();
        queen.setFlirtiness(true);
        return queen;
    }

    /**
     * Method to create a not flirty queen.
     *
     * @return A not flirty {@link Queen}.
     */
    public static Queen createNotFlirtyQueen() {
        return new Queen();
    }
}
