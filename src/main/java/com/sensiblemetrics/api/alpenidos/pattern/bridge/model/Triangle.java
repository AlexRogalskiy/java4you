package com.sensiblemetrics.api.alpenidos.pattern.bridge.model;

import com.sensiblemetrics.api.alpenidos.pattern.bridge.iface.Color;

public class Triangle extends Shape {

    public Triangle(final Color color) {
        super(color);
    }

    @Override
    public String draw() {
        return "Triangle drawn. " + this.color.fill();
    }
}
