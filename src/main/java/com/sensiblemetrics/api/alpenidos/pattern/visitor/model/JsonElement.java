package com.sensiblemetrics.api.alpenidos.pattern.visitor.model;

import com.sensiblemetrics.api.alpenidos.pattern.visitor.iface.Visitor;

public class JsonElement extends Element {

    public JsonElement(final String uuid) {
        super(uuid);
    }

    public void accept(final Visitor v) {
        v.visit(this);
    }
}
