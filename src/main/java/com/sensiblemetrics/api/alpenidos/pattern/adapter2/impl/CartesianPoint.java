package com.sensiblemetrics.api.alpenidos.pattern.adapter2.impl;

import com.sensiblemetrics.api.alpenidos.pattern.adapter2.iface.Cartesian;

public class CartesianPoint implements Cartesian {

    @Override
    public void setPoint(double x, double y) {
        System.out.println("x: " + x + " y: " + y);
    }
}
