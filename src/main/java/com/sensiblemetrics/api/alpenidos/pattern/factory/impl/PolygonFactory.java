package com.sensiblemetrics.api.alpenidos.pattern.factory.impl;

import com.sensiblemetrics.api.alpenidos.pattern.factory.iface.Polygon;
import com.sensiblemetrics.api.alpenidos.pattern.factory.model.*;

public class PolygonFactory {

    public Polygon getPolygon(final int numberOfSides) {
        if (numberOfSides == 3) {
            return new Triangle();
        }
        if (numberOfSides == 4) {
            return new Square();
        }
        if (numberOfSides == 5) {
            return new Pentagon();
        }
        if (numberOfSides == 7) {
            return new Heptagon();
        }
        if (numberOfSides == 8) {
            return new Octagon();
        }
        return null;
    }
}
