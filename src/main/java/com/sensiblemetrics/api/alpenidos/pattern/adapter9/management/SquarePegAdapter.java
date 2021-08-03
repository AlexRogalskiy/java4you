package com.sensiblemetrics.api.alpenidos.pattern.adapter9.management;

import com.sensiblemetrics.api.alpenidos.pattern.adapter9.round.RoundPeg;
import com.sensiblemetrics.api.alpenidos.pattern.adapter9.square.SquarePeg;

/**
 * EN: Adapter allows fitting square pegs into round holes.
 * <p>
 * RU: Адаптер позволяет использовать КвадратныеКолышки и КруглыеОтверстия вместе.
 */
public class SquarePegAdapter extends RoundPeg {

    private final SquarePeg peg;

    public SquarePegAdapter(SquarePeg peg) {
        this.peg = peg;
    }

    @Override
    public double getRadius() {
        return Math.sqrt(Math.pow((peg.getWidth() / 2), 2) * 2);
    }
}
