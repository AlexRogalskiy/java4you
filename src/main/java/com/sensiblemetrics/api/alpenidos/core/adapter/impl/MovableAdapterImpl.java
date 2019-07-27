package com.sensiblemetrics.api.alpenidos.core.adapter.impl;

import com.sensiblemetrics.api.alpenidos.core.adapter.iface.Movable;
import com.sensiblemetrics.api.alpenidos.core.adapter.iface.MovableAdapter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MovableAdapterImpl implements MovableAdapter {
    private final Movable luxuryCars;

    @Override
    public double getSpeed() {
        double mph = this.luxuryCars.getSpeed();
        return this.convertMPHtoKMPH(mph);
    }

    private double convertMPHtoKMPH(double mph) {
        return mph * 1.60934;
    }
}
