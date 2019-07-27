package com.sensiblemetrics.api.alpenidos.core.bridge.model;

import com.sensiblemetrics.api.alpenidos.core.bridge.iface.Color;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
public abstract class Shape {
    protected final Color color;

    abstract public String draw();
}
