package com.sensiblemetrics.api.alpenidos.core.acyclic_visitor.iface;

import com.sensiblemetrics.api.alpenidos.core.acyclic_visitor.model.Hayes;

/**
 * HayesVisitor interface
 */
public interface HayesVisitor extends ModemVisitor {
  void visit(Hayes hayes);
}
