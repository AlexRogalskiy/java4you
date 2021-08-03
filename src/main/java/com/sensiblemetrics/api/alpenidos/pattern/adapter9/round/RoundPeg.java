package com.sensiblemetrics.api.alpenidos.pattern.adapter9.round;

/**
 * EN: RoundPegs are compatible with RoundHoles.
 * <p>
 * RU: КруглыеКолышки совместимы с КруглымиОтверстиями.
 */
public class RoundPeg {

    private double radius;

    public RoundPeg() {
    }

    public RoundPeg(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}
