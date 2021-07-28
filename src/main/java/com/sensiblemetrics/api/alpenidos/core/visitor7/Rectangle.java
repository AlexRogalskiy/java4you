package com.sensiblemetrics.api.alpenidos.core.visitor7;

/**
 * @author Alexander Pashinskiy
 * @version 1.0
 * @since 12/06/2016
 */
public class Rectangle implements Element {

    public final double width;
    public final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
