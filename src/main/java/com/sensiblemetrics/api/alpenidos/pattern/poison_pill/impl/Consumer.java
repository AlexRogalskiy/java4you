package com.sensiblemetrics.api.alpenidos.pattern.poison_pill.impl;

import com.sensiblemetrics.api.alpenidos.pattern.poison_pill.iface.Message;
import com.sensiblemetrics.api.alpenidos.pattern.poison_pill.iface.MqSubscribePoint;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Class responsible for receiving and handling submitted to the queue messages
 */
@Slf4j
@RequiredArgsConstructor
public class Consumer {

    private final String name;
    private final MqSubscribePoint queue;

    /**
     * Consume message
     */
    public void consume() {
        while (true) {
            Message msg;
            try {
                msg = this.queue.take();
                if (Message.POISON_PILL.equals(msg)) {
                    log.info("Consumer {} receive request to terminate.", name);
                    break;
                }
            } catch (InterruptedException e) {
                // allow thread to exit
                log.error("Exception caught.", e);
                return;
            }

            final String sender = msg.getHeader(Message.Headers.SENDER);
            final String body = msg.getBody();
            log.info("Message [{}] from [{}] received by [{}]", body, sender, name);
        }
    }
}
