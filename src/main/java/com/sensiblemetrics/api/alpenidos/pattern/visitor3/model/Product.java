package com.sensiblemetrics.api.alpenidos.pattern.visitor3.model;

import com.sensiblemetrics.api.alpenidos.pattern.visitor3.impl.Visitor;

public interface Product {

    void accept(final Visitor visitor);
}
