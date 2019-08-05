package com.sensiblemetrics.api.alpenidos.core.semaphore.model;

import com.sensiblemetrics.api.alpenidos.core.semaphore.impl.Semaphore;

import java.util.Arrays;

/**
 * A FruitShop contains three FruitBowl instances and controls access to them.
 */
public class FruitShop {

    /**
     * The FruitBowl instances stored in the class.
     */
    private FruitBowl[] bowls = {
        new FruitBowl(),
        new FruitBowl(),
        new FruitBowl()
    };

    /**
     * Access flags for each of the FruitBowl instances.
     */
    private boolean[] available = {
        true,
        true,
        true
    };

    /**
     * The Semaphore that controls access to the class resources.
     */
    private Semaphore semaphore;

    /**
     * FruitShop constructor
     */
    public FruitShop() {
        for (int i = 0; i < 100; i++) {
            this.bowls[0].put(new Fruit(Fruit.FruitType.APPLE));
            this.bowls[1].put(new Fruit(Fruit.FruitType.ORANGE));
            this.bowls[2].put(new Fruit(Fruit.FruitType.LEMON));
        }
        this.semaphore = new Semaphore(3);
    }

    /**
     * @return The amount of Fruit left in the shop.
     */
    public synchronized long countFruit() {
        return Arrays.stream(this.bowls).map(FruitBowl::countFruit).count();
    }

    /**
     * Method called by Customer to get a FruitBowl from the shop. This method
     * will try to acquire the Semaphore before returning the first available
     * FruitBowl.
     */
    public synchronized FruitBowl takeBowl() {
        FruitBowl bowl = null;

        try {
            this.semaphore.acquire();

            if (this.available[0]) {
                bowl = this.bowls[0];
                this.available[0] = false;
            } else if (available[1]) {
                bowl = this.bowls[1];
                this.available[1] = false;
            } else if (this.available[2]) {
                bowl = this.bowls[2];
                this.available[2] = false;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            this.semaphore.release();
        }
        return bowl;
    }

    /**
     * Method called by a Customer instance to return a FruitBowl to the shop.
     * This method releases the Semaphore, making the FruitBowl available to
     * another Customer.
     */
    public synchronized void returnBowl(final FruitBowl bowl) {
        if (bowl == this.bowls[0]) {
            this.available[0] = true;
        } else if (bowl == bowls[1]) {
            this.available[1] = true;
        } else if (bowl == bowls[2]) {
            this.available[2] = true;
        }
    }
}
