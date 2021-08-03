package com.sensiblemetrics.api.alpenidos.pattern.adapter2;

import com.sensiblemetrics.api.alpenidos.pattern.adapter2.iface.Polar;
import com.sensiblemetrics.api.alpenidos.pattern.adapter2.impl.CartesianPoint;
import com.sensiblemetrics.api.alpenidos.pattern.adapter2.impl.Polar2CartesianAdapter;

public class AdapterPattern2Loader {
    public static void main(final String[] args) {
        final Polar adapter = new Polar2CartesianAdapter(new CartesianPoint());
        adapter.setPoint(0, 42);
        adapter.setPoint(1, Math.PI / 2);
        adapter.setPoint(2, Math.PI);
    }
}
