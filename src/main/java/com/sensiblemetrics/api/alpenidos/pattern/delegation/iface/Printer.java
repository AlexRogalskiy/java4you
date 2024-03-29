package com.sensiblemetrics.api.alpenidos.pattern.delegation.iface;

import com.sensiblemetrics.api.alpenidos.pattern.delegation.impl.CanonPrinter;
import com.sensiblemetrics.api.alpenidos.pattern.delegation.impl.EpsonPrinter;
import com.sensiblemetrics.api.alpenidos.pattern.delegation.impl.HpPrinter;

/**
 * Interface that both the Controller and the Delegate will implement.
 *
 * @see CanonPrinter
 * @see EpsonPrinter
 * @see HpPrinter
 */
public interface Printer {

    /**
     * Method that takes a String to print to the screen. This will be implemented on both the
     * controller and the delegate allowing the controller to call the same method on the delegate class.
     *
     * @param message to be printed to the screen
     */
    void print(final String message);
}
