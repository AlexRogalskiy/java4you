package com.sensiblemetrics.api.alpenidos.pattern.factory.model;

import com.sensiblemetrics.api.alpenidos.pattern.factory.iface.Polygon;

public class Pentagon implements Polygon {

    @Override
    public String getType() {
        return "Pentagon";
    }
}
