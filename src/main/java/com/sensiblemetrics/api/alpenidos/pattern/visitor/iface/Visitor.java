package com.sensiblemetrics.api.alpenidos.pattern.visitor.iface;

import com.sensiblemetrics.api.alpenidos.pattern.visitor.model.JsonElement;
import com.sensiblemetrics.api.alpenidos.pattern.visitor.model.XmlElement;

public interface Visitor {

    void visit(final XmlElement xe);

    void visit(final JsonElement je);
}
