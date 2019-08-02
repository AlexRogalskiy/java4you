package com.sensiblemetrics.api.alpenidos.core.acyclic_visitor.model;

import com.sensiblemetrics.api.alpenidos.core.acyclic_visitor.iface.ModemVisitor;

/**
 * Modem abstract class
 */
public abstract class Modem {

    public abstract void accept(final ModemVisitor modemVisitor);
}
