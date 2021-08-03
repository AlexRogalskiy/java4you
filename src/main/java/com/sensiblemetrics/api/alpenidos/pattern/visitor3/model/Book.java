package com.sensiblemetrics.api.alpenidos.pattern.visitor3.model;

import com.sensiblemetrics.api.alpenidos.pattern.visitor3.impl.Visitor;

public class Book implements Product {

    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }
}
