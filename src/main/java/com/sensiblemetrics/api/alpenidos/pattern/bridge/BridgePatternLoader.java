package com.sensiblemetrics.api.alpenidos.pattern.bridge;

import com.sensiblemetrics.api.alpenidos.pattern.bridge.model.*;

public class BridgePatternLoader {

    public static void main(final String[] args) {
        //a square with red color
        final Shape square = new Square(new Red());
        System.out.println(square.draw());

        //a triangle with blue color
        final Shape triangle = new Triangle(new Blue());
        System.out.println(triangle.draw());
    }
}
