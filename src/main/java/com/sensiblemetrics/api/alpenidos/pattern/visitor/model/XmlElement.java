package com.sensiblemetrics.api.alpenidos.pattern.visitor.model;

import com.sensiblemetrics.api.alpenidos.pattern.visitor.iface.Visitor;

public class XmlElement extends Element {

    public XmlElement(final String uuid) {
        super(uuid);
    }

    public void accept(final Visitor v) {
        v.visit(this);
    }
}
