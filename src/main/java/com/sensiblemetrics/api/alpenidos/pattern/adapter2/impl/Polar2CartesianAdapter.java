package com.sensiblemetrics.api.alpenidos.pattern.adapter2.impl;

import com.sensiblemetrics.api.alpenidos.pattern.adapter2.iface.Cartesian;
import com.sensiblemetrics.api.alpenidos.pattern.adapter2.iface.Polar;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Polar2CartesianAdapter implements Polar {
    private final Cartesian cartesian;

    @Override
    public void setPoint(double r, double theta) {
        this.cartesian.setPoint(r * Math.cos(theta), r * Math.sin(theta));
    }
}
