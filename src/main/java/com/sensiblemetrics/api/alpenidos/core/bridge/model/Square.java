package com.sensiblemetrics.api.alpenidos.core.bridge.model;

import com.sensiblemetrics.api.alpenidos.core.bridge.iface.Color;
import com.sensiblemetrics.api.alpenidos.core.bridge.model.Shape;

public class Square extends Shape {

    public Square(final Color color) {
        super(color);
    }

    @Override
    public String draw() {
        return "Square drawn. " + color.fill();
    }
}
