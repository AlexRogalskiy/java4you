package com.sensiblemetrics.api.alpenidos.core.delegation.impl;

import com.sensiblemetrics.api.alpenidos.core.delegation.iface.Printer;
import lombok.extern.slf4j.Slf4j;

/**
 * Specialised Implementation of {@link Printer} for a HP Printer, in
 * this case the message to be printed is appended to "HP Printer : "
 *
 * @see Printer
 */
@Slf4j
public class HpPrinter implements Printer {

    /**
     * {@inheritDoc}
     */
    @Override
    public void print(final String message) {
        log.info("HP Printer : {}", message);
    }
}
