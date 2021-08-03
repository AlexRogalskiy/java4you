package com.sensiblemetrics.api.alpenidos.pattern.queue_load_leveling.iface;

import com.sensiblemetrics.api.alpenidos.pattern.queue_load_leveling.model.Message;

/**
 * Task Interface.
 */
public interface Task {

    void submit(final Message msg);
}
