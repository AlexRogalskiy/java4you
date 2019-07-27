package com.sensiblemetrics.api.alpenidos.core.visitor.iface;

import com.sensiblemetrics.api.alpenidos.core.visitor.model.JsonElement;
import com.sensiblemetrics.api.alpenidos.core.visitor.model.XmlElement;

public interface Visitor {

    void visit(final XmlElement xe);

    void visit(final JsonElement je);
}
