package com.sensiblemetrics.api.alpenidos.core.visitor3.model;

import com.sensiblemetrics.api.alpenidos.core.visitor3.impl.Visitor;
import com.sensiblemetrics.api.alpenidos.core.visitor3.model.Product;

public class Apple implements Product {

    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }
}
