package com.sensiblemetrics.api.alpenidos.pattern.pub_sub.queue;

import com.sensiblemetrics.api.alpenidos.pattern.pub_sub.impl.Consumer;
import com.sensiblemetrics.api.alpenidos.pattern.pub_sub.impl.Producer;
import com.sensiblemetrics.api.alpenidos.pattern.pub_sub.model.Item;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Class as a channel for {@link Producer}-{@link Consumer} exchange.
 */
public class ItemQueue {
    private final BlockingQueue<Item> queue;

    public ItemQueue() {
        this.queue = new LinkedBlockingQueue<>(5);
    }

    public void put(final Item item) throws InterruptedException {
        this.queue.put(item);
    }

    public Item take() throws InterruptedException {
        return this.queue.take();
    }
}
