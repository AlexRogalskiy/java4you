package com.sensiblemetrics.api.alpenidos.core.factory;

import com.sensiblemetrics.api.alpenidos.core.factory.iface.Polygon;
import com.sensiblemetrics.api.alpenidos.core.factory.impl.PolygonFactory;

public class FactoryPatternLoader {

    public static void main(final String[] args) {
        final PolygonFactory factory = new PolygonFactory();

        //get the shape which has 4 sides
        final Polygon fourSidePolygon = factory.getPolygon(4);
        System.out.println("The shape with 4 sides is a " + fourSidePolygon.getType());

        //get the shape which has 4 sides
        final Polygon eightSidePolygon = factory.getPolygon(8);
        System.out.println("The shape with 8 sides is a " + eightSidePolygon.getType());
    }
}
