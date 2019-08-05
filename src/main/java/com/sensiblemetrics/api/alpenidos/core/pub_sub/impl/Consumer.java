package com.sensiblemetrics.api.alpenidos.core.pub_sub.impl;

import com.sensiblemetrics.api.alpenidos.core.pub_sub.model.Item;
import com.sensiblemetrics.api.alpenidos.core.pub_sub.queue.ItemQueue;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Class responsible for consume the {@link Item} produced by {@link Producer}
 */
@Slf4j
@RequiredArgsConstructor
public class Consumer {
    private final String name;
    private final ItemQueue queue;

    /**
     * Consume item from the queue
     */
    public void consume() throws InterruptedException {
        final Item item = this.queue.take();
        log.info("Consumer [{}] consume item [{}] produced by [{}]", name, item.getId(), item.getProducer());
    }
}
