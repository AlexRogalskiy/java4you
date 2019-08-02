package com.sensiblemetrics.api.alpenidos.core.acyclic_visitor;

import com.sensiblemetrics.api.alpenidos.core.acyclic_visitor.iface.HayesVisitor;
import com.sensiblemetrics.api.alpenidos.core.acyclic_visitor.iface.ModemVisitor;
import com.sensiblemetrics.api.alpenidos.core.acyclic_visitor.iface.ZoomVisitor;
import com.sensiblemetrics.api.alpenidos.core.acyclic_visitor.impl.ConfigureForDosVisitor;
import com.sensiblemetrics.api.alpenidos.core.acyclic_visitor.impl.ConfigureForUnixVisitor;
import com.sensiblemetrics.api.alpenidos.core.acyclic_visitor.model.Hayes;
import com.sensiblemetrics.api.alpenidos.core.acyclic_visitor.model.Modem;
import com.sensiblemetrics.api.alpenidos.core.acyclic_visitor.model.Zoom;

/**
 * The Acyclic Visitor pattern allows new functions to be added to existing class
 * hierarchies without affecting those hierarchies, and without creating the dependency
 * cycles that are inherent to the GoF Visitor pattern, by making the Visitor base class
 * degenerate
 * <p>
 * In this example the visitor base class is {@link ModemVisitor}. The base class of the
 * visited hierarchy is {@link Modem} and has two children {@link Hayes} and {@link Zoom}
 * each one having its own visitor interface {@link HayesVisitor} and {@link ZoomVisitor}
 * respectively. {@link ConfigureForUnixVisitor} and {@link ConfigureForDosVisitor}
 * implement each derivative's visit method only if it is required
 */
public class AcyclicVisitorPatternLoader {

    /**
     * Program's entry point
     */
    public static void main(final String[] args) {
        final ConfigureForUnixVisitor conUnix = new ConfigureForUnixVisitor();
        final ConfigureForDosVisitor conDos = new ConfigureForDosVisitor();

        final Zoom zoom = new Zoom();
        final Hayes hayes = new Hayes();

        hayes.accept(conDos); // Hayes modem with Unix configurator
        zoom.accept(conDos); // Zoom modem with Dos configurator
        hayes.accept(conUnix); // Hayes modem with Unix configurator
        zoom.accept(conUnix); // Zoom modem with Unix configurator
    }
}
