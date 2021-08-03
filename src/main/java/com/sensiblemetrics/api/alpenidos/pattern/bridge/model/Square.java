package com.sensiblemetrics.api.alpenidos.pattern.bridge.model;

import com.sensiblemetrics.api.alpenidos.pattern.bridge.iface.Color;

public class Square extends Shape {

    public Square(final Color color) {
        super(color);
    }

    @Override
    public String draw() {
        return "Square drawn. " + color.fill();
    }
}
