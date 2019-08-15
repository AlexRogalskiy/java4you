package com.sensiblemetrics.api.alpenidos.core.adapter5;

import com.sensiblemetrics.api.alpenidos.core.adapter4.Shape;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GeometricShapeObjectAdapter implements Shape {
    private GeometricShape adaptee;

    public GeometricShapeObjectAdapter(final GeometricShape adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void draw() {
        this.adaptee.drawShape();
    }

    @Override
    public void resize() {
        log.info(description() + " can't be resized. Please create new one with required values.");
    }

    @Override
    public String description() {
        if (this.adaptee instanceof Triangle) {
            return "Triangle object";
        } else if (this.adaptee instanceof Rhombus) {
            return "Rhombus object";
        }
        return "Unknown object";
    }

    @Override
    public boolean isHide() {
        return false;
    }
}
