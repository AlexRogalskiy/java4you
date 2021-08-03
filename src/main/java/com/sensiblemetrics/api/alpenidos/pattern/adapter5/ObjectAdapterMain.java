package com.sensiblemetrics.api.alpenidos.pattern.adapter5;

import com.sensiblemetrics.api.alpenidos.pattern.adapter4.Circle;
import com.sensiblemetrics.api.alpenidos.pattern.adapter4.Drawing;
import com.sensiblemetrics.api.alpenidos.pattern.adapter4.Rectangle;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ObjectAdapterMain {

    public static void main(final String[] args) {
        log.info("Creating drawing of shapes...");

        final Drawing drawing = new Drawing();
        drawing.addShape(new Rectangle());
        drawing.addShape(new Circle());
        drawing.addShape(new GeometricShapeObjectAdapter(new Triangle()));
        drawing.addShape(new GeometricShapeObjectAdapter(new Rhombus()));

        log.info("Drawing...");
        drawing.draw();

        log.info("Resizing...");
        drawing.resize();
    }
}
