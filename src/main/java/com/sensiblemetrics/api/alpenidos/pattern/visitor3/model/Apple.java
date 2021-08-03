package com.sensiblemetrics.api.alpenidos.pattern.visitor3.model;

import com.sensiblemetrics.api.alpenidos.pattern.visitor3.impl.Visitor;

public class Apple implements Product {

    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }
}
