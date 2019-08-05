package com.sensiblemetrics.api.alpenidos.core.queue_load_leveling.iface;

import com.sensiblemetrics.api.alpenidos.core.queue_load_leveling.model.Message;

/**
 * Task Interface.
 */
public interface Task {

    void submit(final Message msg);
}
