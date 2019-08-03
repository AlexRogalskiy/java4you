package com.sensiblemetrics.api.alpenidos.core.delegation;

import com.sensiblemetrics.api.alpenidos.core.delegation.controller.PrinterController;
import com.sensiblemetrics.api.alpenidos.core.delegation.iface.Printer;
import com.sensiblemetrics.api.alpenidos.core.delegation.impl.CanonPrinter;
import com.sensiblemetrics.api.alpenidos.core.delegation.impl.EpsonPrinter;
import com.sensiblemetrics.api.alpenidos.core.delegation.impl.HpPrinter;

/**
 * The delegate pattern provides a mechanism to abstract away the implementation and control of the desired action.
 * The class being called in this case {@link PrinterController} is not responsible for the actual desired action,
 * but is actually delegated to a helper class either {@link CanonPrinter}, {@link EpsonPrinter} or {@link HpPrinter}.
 * The consumer does not have or require knowledge of the actual class carrying out the action, only the
 * container on which they are calling.
 * <p>
 * In this example the delegates are {@link EpsonPrinter}, {@link HpPrinter} and {@link CanonPrinter} they all implement
 * {@link Printer}. The {@link PrinterController} class also implements {@link Printer}. However neither provide the
 * functionality of {@link Printer} by printing to the screen, they actually call upon the instance of {@link Printer}
 * that they were instantiated with. Therefore delegating the behaviour to another class.
 */
public class DelegationPatternLoader {

    private static final String MESSAGE_TO_PRINT = "hello world";

    /**
     * Program entry point
     *
     * @param args command line args
     */
    public static void main(final String[] args) {
        final PrinterController hpPrinterController = new PrinterController(new HpPrinter());
        final PrinterController canonPrinterController = new PrinterController(new CanonPrinter());
        final PrinterController epsonPrinterController = new PrinterController(new EpsonPrinter());

        hpPrinterController.print(MESSAGE_TO_PRINT);
        canonPrinterController.print(MESSAGE_TO_PRINT);
        epsonPrinterController.print(MESSAGE_TO_PRINT);
    }
}
