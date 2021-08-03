package com.sensiblemetrics.api.alpenidos.pattern.pub_sub.impl;

import com.sensiblemetrics.api.alpenidos.pattern.pub_sub.queue.ItemQueue;
import com.sensiblemetrics.api.alpenidos.pattern.pub_sub.model.Item;
import lombok.RequiredArgsConstructor;

import java.util.Random;

/**
 * Class responsible for producing unit of work that can be expressed as {@link Item} and submitted
 * to queue
 */
@RequiredArgsConstructor
public class Producer {
    private final String name;
    private final ItemQueue queue;
    private int itemId;

    /**
     * Put item in the queue
     */
    public void produce() throws InterruptedException {
        final Item item = new Item(this.name, this.itemId++);
        this.queue.put(item);
        final Random random = new Random();
        Thread.sleep(random.nextInt(2000));
    }
}
