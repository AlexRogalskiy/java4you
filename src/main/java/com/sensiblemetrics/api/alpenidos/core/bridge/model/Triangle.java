package com.sensiblemetrics.api.alpenidos.core.bridge.model;

import com.sensiblemetrics.api.alpenidos.core.bridge.iface.Color;
import com.sensiblemetrics.api.alpenidos.core.bridge.model.Shape;

public class Triangle extends Shape {

    public Triangle(final Color color) {
        super(color);
    }

    @Override
    public String draw() {
        return "Triangle drawn. " + this.color.fill();
    }
}
