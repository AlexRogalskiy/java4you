package com.sensiblemetrics.api.alpenidos.core.poison_pill.impl;

import com.sensiblemetrics.api.alpenidos.core.poison_pill.iface.Message;
import com.sensiblemetrics.api.alpenidos.core.poison_pill.iface.MqPublishPoint;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * Class responsible for producing unit of work that can be expressed as message and submitted to
 * queue
 */
@Slf4j
@RequiredArgsConstructor
public class Producer {
    private final String name;
    private final MqPublishPoint queue;
    private boolean isStopped;

    /**
     * Send message to queue
     */
    public void send(final String body) {
        if (this.isStopped) {
            throw new IllegalStateException(String.format("Producer %s was stopped and fail to deliver requested message [%s].", body, name));
        }
        final Message msg = new SimpleMessage();
        msg.addHeader(Message.Headers.DATE, new Date().toString());
        msg.addHeader(Message.Headers.SENDER, name);
        msg.setBody(body);

        try {
            this.queue.put(msg);
        } catch (InterruptedException e) {
            // allow thread to exit
            log.error("Exception caught.", e);
        }
    }

    /**
     * Stop system by sending poison pill
     */
    public void stop() {
        this.isStopped = true;
        try {
            this.queue.put(Message.POISON_PILL);
        } catch (InterruptedException e) {
            // allow thread to exit
            log.error("Exception caught.", e);
        }
    }
}
