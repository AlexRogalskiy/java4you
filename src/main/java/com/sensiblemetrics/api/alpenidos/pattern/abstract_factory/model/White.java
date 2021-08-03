package com.sensiblemetrics.api.alpenidos.pattern.abstract_factory.model;

import com.sensiblemetrics.api.alpenidos.pattern.abstract_factory.iface.Color;

public class White implements Color {

    @Override
    public String getColor() {
        return "White";
    }
}
