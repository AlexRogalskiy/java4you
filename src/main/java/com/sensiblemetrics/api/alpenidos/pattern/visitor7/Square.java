package com.sensiblemetrics.api.alpenidos.pattern.visitor7;

/**
 * @author Alexander Pashinskiy
 * @since 12/06/2016
 * @version 1.0
 */
public class Square implements Element {
    public final double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
