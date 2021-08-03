package com.sensiblemetrics.api.alpenidos.pattern.acyclic_visitor.iface;

import com.sensiblemetrics.api.alpenidos.pattern.acyclic_visitor.model.Hayes;

/**
 * HayesVisitor interface
 */
public interface HayesVisitor extends ModemVisitor {
  void visit(Hayes hayes);
}
