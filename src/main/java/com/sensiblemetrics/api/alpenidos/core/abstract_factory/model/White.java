package com.sensiblemetrics.api.alpenidos.core.abstract_factory.model;

import com.sensiblemetrics.api.alpenidos.core.abstract_factory.iface.Color;

public class White implements Color {

    @Override
    public String getColor() {
        return "White";
    }
}
