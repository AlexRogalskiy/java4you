package com.sensiblemetrics.api.alpenidos.pattern.disk_buffer;

import java.util.Iterator;

public interface Buffer {
    /**
     * Buffer the {@link Event} so that it can be flushed to the Sentry server at a later
     * point in time.
     *
     * @param event Event object that should be buffered.
     */
    void add(final Event event);

    /**
     * Discard and {@link Event} from the buffer. Note: the {@link Event} may or may not exist in
     * the buffer.
     *
     * @param event Event to discard from the buffer.
     */
    void discard(final Event event);

    /**
     * Returns an Iterator of {@link Event}s in the buffer.
     *
     * @return Iterator of Events in the buffer.
     */
    Iterator<Event> getEvents();
}
