package com.sensiblemetrics.api.alpenidos.pattern.bridge.model;

import com.sensiblemetrics.api.alpenidos.pattern.bridge.iface.Color;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class Shape {
    protected final Color color;

    abstract public String draw();
}
