package com.sensiblemetrics.api.alpenidos.pattern.acyclic_visitor.impl;

import com.sensiblemetrics.api.alpenidos.pattern.acyclic_visitor.iface.ZoomVisitor;
import com.sensiblemetrics.api.alpenidos.pattern.acyclic_visitor.model.Zoom;
import lombok.extern.slf4j.Slf4j;

/**
 * ConfigureForUnixVisitor class implements zoom's visit method for Unix
 * manufacturer, unlike traditional visitor pattern, this class may selectively implement
 * visit for other modems.
 */
@Slf4j
public class ConfigureForUnixVisitor implements ZoomVisitor {

    public void visit(final Zoom zoom) {
        log.info(zoom + " used with Unix configurator.");
    }
}
