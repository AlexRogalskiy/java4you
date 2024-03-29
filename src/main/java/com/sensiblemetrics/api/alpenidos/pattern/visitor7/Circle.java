package com.sensiblemetrics.api.alpenidos.pattern.visitor7;

/**
 * @author Alexander Pashinskiy
 * @since 12/06/2016
 * @version 1.0
 */
public class Circle implements Element {
    public final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
