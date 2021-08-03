package com.sensiblemetrics.api.alpenidos.pattern.poison_pill.iface;

/**
 * Endpoint to retrieve {@link Message} from queue
 */
public interface MqSubscribePoint {

    Message take() throws InterruptedException;
}
