package com.sensiblemetrics.api.alpenidos.core.poison_pill.iface;

import com.sensiblemetrics.api.alpenidos.core.poison_pill.impl.Consumer;
import com.sensiblemetrics.api.alpenidos.core.poison_pill.impl.Producer;

/**
 * Represents abstraction of channel (or pipe) that bounds {@link Producer} and {@link Consumer}
 */
public interface MessageQueue extends MqPublishPoint, MqSubscribePoint {
}
