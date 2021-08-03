package com.sensiblemetrics.api.alpenidos.pattern.adapter9.square;

/**
 * EN: SquarePegs are not compatible with RoundHoles (they were implemented by previous development team). But we have to integrate them into our program.
 * <p>
 * RU: КвадратныеКолышки несовместимы с КруглымиОтверстиями (они остались в проекте после бывших разработчиков). Но мы должны как-то интегрировать их в нашу
 * систему.
 */
public class SquarePeg {

    private final double width;

    public SquarePeg(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public double getSquare() {
        return Math.pow(this.width, 2);
    }
}
