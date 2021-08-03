package com.sensiblemetrics.api.alpenidos.pattern.producer_consumer2.dispatcher;

import com.sensiblemetrics.api.alpenidos.pattern.producer_consumer2.model.TroubleTicket;
import lombok.RequiredArgsConstructor;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * <p>
 * Date: Aug 19, 2011
 *
 * @author moleksyuk
 */
@RequiredArgsConstructor
public class Dispatcher implements Runnable {
    private final Queue queue;

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        @SuppressWarnings("unused") final TroubleTicket ticket = this.queue.pull();
    }
}
