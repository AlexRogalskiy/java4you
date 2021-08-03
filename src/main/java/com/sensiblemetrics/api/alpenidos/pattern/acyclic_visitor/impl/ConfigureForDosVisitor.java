package com.sensiblemetrics.api.alpenidos.pattern.acyclic_visitor.impl;

import com.sensiblemetrics.api.alpenidos.pattern.acyclic_visitor.iface.AllModemVisitor;
import com.sensiblemetrics.api.alpenidos.pattern.acyclic_visitor.model.Hayes;
import com.sensiblemetrics.api.alpenidos.pattern.acyclic_visitor.model.Zoom;
import lombok.extern.slf4j.Slf4j;

/**
 * ConfigureForDosVisitor class implements both zoom's and  hayes' visit method
 * for Dos manufacturer
 */
@Slf4j
public class ConfigureForDosVisitor implements AllModemVisitor {

    public void visit(final Hayes hayes) {
        log.info(hayes + " used with Dos configurator.");
    }

    public void visit(final Zoom zoom) {
        log.info(zoom + " used with Dos configurator.");
    }
}
