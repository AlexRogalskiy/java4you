package com.sensiblemetrics.api.alpenidos.pattern.poison_pill.iface;

/**
 * Endpoint to publish {@link Message} to queue
 */
public interface MqPublishPoint {

    void put(final Message msg) throws InterruptedException;
}
