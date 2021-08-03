package com.sensiblemetrics.api.alpenidos.pattern.acyclic_visitor.iface;

import com.sensiblemetrics.api.alpenidos.pattern.acyclic_visitor.model.Zoom;

/**
 * ZoomVisitor interface
 */
public interface ZoomVisitor extends ModemVisitor {
  void visit(Zoom zoom);
}
