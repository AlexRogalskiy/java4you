package com.sensiblemetrics.api.alpenidos.core.visitor.model;

import com.sensiblemetrics.api.alpenidos.core.visitor.iface.Visitor;
import com.sensiblemetrics.api.alpenidos.core.visitor.model.Element;

public class JsonElement extends Element {

    public JsonElement(final String uuid) {
        super(uuid);
    }

    public void accept(final Visitor v) {
        v.visit(this);
    }
}
