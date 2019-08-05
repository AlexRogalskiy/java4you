package com.sensiblemetrics.api.alpenidos.core.semaphore.model;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * A Customer attempts to repeatedly take Fruit from the FruitShop by
 * taking Fruit from FruitBowl instances.
 */
@Slf4j
@RequiredArgsConstructor
public class Customer extends Thread {

    /**
     * Name of the Customer.
     */
    private final String name;

    /**
     * The FruitShop he is using.
     */
    private final FruitShop fruitShop;

    /**
     * Their bowl of Fruit.
     */
    private FruitBowl fruitBowl;

    /**
     * The Customer repeatedly takes Fruit from the FruitShop until no Fruit
     * remains.
     */
    public void run() {
        while (this.fruitShop.countFruit() > 0) {
            final FruitBowl bowl = this.fruitShop.takeBowl();
            Fruit fruit;

            if (bowl != null && (fruit = bowl.take()) != null) {
                log.info("{} took an {}", this.name, fruit);
                this.fruitBowl.put(fruit);
                this.fruitShop.returnBowl(bowl);
            }
        }
        log.info("{} took {}", this.name, this.fruitBowl);
    }
}
