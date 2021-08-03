package com.sensiblemetrics.api.alpenidos.pattern.semaphore.model;

import java.util.ArrayList;
import java.util.List;

/**
 * A FruitBowl contains Fruit.
 */
public class FruitBowl {
    private final List<Fruit> fruit = new ArrayList<>();

    /**
     * @return The amount of Fruit left in the bowl.
     */
    public int countFruit() {
        return this.fruit.size();
    }

    /**
     * Put an item of Fruit into the bowl.
     *
     * @param f fruit
     */
    public void put(final Fruit f) {
        this.fruit.add(f);
    }

    /**
     * Take an item of Fruit out of the bowl.
     *
     * @return The Fruit taken out of the bowl, or null if empty.
     */
    public Fruit take() {
        if (this.fruit.isEmpty()) {
            return null;
        }
        return fruit.remove(0);
    }

    /**
     * toString method
     */
    public String toString() {
        int apples = 0;
        int oranges = 0;
        int lemons = 0;

        for (final Fruit f : fruit) {
            switch (f.getType()) {
                case APPLE:
                    apples++;
                    break;
                case ORANGE:
                    oranges++;
                    break;
                case LEMON:
                    lemons++;
                    break;
                default:
            }
        }
        return apples + " Apples, " + oranges + " Oranges, and " + lemons + " Lemons";
    }
}
