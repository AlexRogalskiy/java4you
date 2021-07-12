package com.sensiblemetrics.api.alpenidos.core.adapter9.round;

/**
 * EN: RoundHoles are compatible with RoundPegs.
 * <p>
 * RU: КруглоеОтверстие совместимо с КруглымиКолышками.
 */
public class RoundHole {

    private final double radius;

    public RoundHole(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public boolean fits(final RoundPeg peg) {
        return (this.getRadius() >= peg.getRadius());
    }
}
