package com.sensiblemetrics.api.alpenidos.pattern.visitor5.model;

import com.sensiblemetrics.api.alpenidos.pattern.visitor5.management.Visitor;
import java.util.ArrayList;
import java.util.List;

public class CompoundShape implements Shape {

    public int id;
    public final List<Shape> children = new ArrayList<>();

    public CompoundShape(int id) {
        this.id = id;
    }

    @Override
    public void move(int x, int y) {
        // move shape
    }

    @Override
    public void draw() {
        // draw shape
    }

    public int getId() {
        return id;
    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visitCompoundGraphic(this);
    }

    public void add(Shape shape) {
        children.add(shape);
    }
}
