package com.sensiblemetrics.api.alpenidos.core.visitor5.model;

import com.sensiblemetrics.api.alpenidos.core.visitor5.management.Visitor;

public interface Shape {

    void move(int x, int y);

    void draw();

    String accept(Visitor visitor);
}
