package com.sensiblemetrics.api.alpenidos.pattern.delegation.impl;

import com.sensiblemetrics.api.alpenidos.pattern.delegation.iface.Printer;
import lombok.extern.slf4j.Slf4j;

/**
 * Specialised Implementation of {@link Printer} for a Canon Printer, in
 * this case the message to be printed is appended to "Canon Printer : "
 *
 * @see Printer
 */
@Slf4j
public class CanonPrinter implements Printer {

    /**
     * {@inheritDoc}
     */
    @Override
    public void print(final String message) {
        log.info("Canon Printer : {}", message);
    }
}
