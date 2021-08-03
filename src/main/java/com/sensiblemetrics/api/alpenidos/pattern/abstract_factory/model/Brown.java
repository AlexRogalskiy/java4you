package com.sensiblemetrics.api.alpenidos.pattern.abstract_factory.model;

import com.sensiblemetrics.api.alpenidos.pattern.abstract_factory.iface.Color;

public class Brown implements Color {

    @Override
    public String getColor() {
        return "Brown";
    }
}
