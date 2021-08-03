package com.sensiblemetrics.api.alpenidos.pattern.event.asynchronous.iface;

/**
 * Interface with listener behaviour related to Thread Completion.
 */
public interface ThreadCompleteListener {

    void completedEventHandler(final int eventId);
}
