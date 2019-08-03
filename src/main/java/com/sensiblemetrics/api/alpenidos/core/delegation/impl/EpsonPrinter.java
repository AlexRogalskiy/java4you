package com.sensiblemetrics.api.alpenidos.core.delegation.impl;

import com.sensiblemetrics.api.alpenidos.core.delegation.iface.Printer;
import lombok.extern.slf4j.Slf4j;

/**
 * Specialised Implementation of {@link Printer} for a Epson Printer, in
 * this case the message to be printed is appended to "Epson Printer : "
 *
 * @see Printer
 */
@Slf4j
public class EpsonPrinter implements Printer {

    /**
     * {@inheritDoc}
     */
    @Override
    public void print(final String message) {
        log.info("Epson Printer : {}", message);
    }
}
