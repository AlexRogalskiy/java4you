package com.sensiblemetrics.api.alpenidos.pattern.poison_pill.impl;

import com.sensiblemetrics.api.alpenidos.pattern.poison_pill.iface.Message;
import com.sensiblemetrics.api.alpenidos.pattern.poison_pill.iface.MessageQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Bounded blocking queue wrapper
 */
public class SimpleMessageQueue implements MessageQueue {

    private final BlockingQueue<Message> queue;

    public SimpleMessageQueue(final int bound) {
        this.queue = new ArrayBlockingQueue<>(bound);
    }

    @Override
    public void put(final Message msg) throws InterruptedException {
        this.queue.put(msg);
    }

    @Override
    public Message take() throws InterruptedException {
        return this.queue.take();
    }
}
