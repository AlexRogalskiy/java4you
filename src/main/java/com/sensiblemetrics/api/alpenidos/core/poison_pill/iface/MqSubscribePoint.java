package com.sensiblemetrics.api.alpenidos.core.poison_pill.iface;

import com.sensiblemetrics.api.alpenidos.core.poison_pill.iface.Message;

/**
 * Endpoint to retrieve {@link Message} from queue
 */
public interface MqSubscribePoint {

    Message take() throws InterruptedException;
}
