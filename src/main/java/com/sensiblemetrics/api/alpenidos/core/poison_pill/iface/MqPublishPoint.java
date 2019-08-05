package com.sensiblemetrics.api.alpenidos.core.poison_pill.iface;

import com.sensiblemetrics.api.alpenidos.core.poison_pill.iface.Message;

/**
 * Endpoint to publish {@link Message} to queue
 */
public interface MqPublishPoint {

    void put(final Message msg) throws InterruptedException;
}
