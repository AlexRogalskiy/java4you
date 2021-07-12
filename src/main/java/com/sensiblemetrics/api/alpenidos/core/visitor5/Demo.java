package com.sensiblemetrics.api.alpenidos.core.visitor5;

import com.sensiblemetrics.api.alpenidos.core.visitor5.management.XMLExportVisitor;
import com.sensiblemetrics.api.alpenidos.core.visitor5.model.Circle;
import com.sensiblemetrics.api.alpenidos.core.visitor5.model.CompoundShape;
import com.sensiblemetrics.api.alpenidos.core.visitor5.model.Dot;
import com.sensiblemetrics.api.alpenidos.core.visitor5.model.Rectangle;
import com.sensiblemetrics.api.alpenidos.core.visitor5.model.Shape;

public class Demo {

    public static void main(String[] args) {
        final Dot dot = new Dot(1, 10, 55);
        final Circle circle = new Circle(2, 23, 15, 10);
        final Rectangle rectangle = new Rectangle(3, 10, 17, 20, 30);

        final CompoundShape compoundShape = new CompoundShape(4);
        compoundShape.add(dot);
        compoundShape.add(circle);
        compoundShape.add(rectangle);

        final CompoundShape c = new CompoundShape(5);
        c.add(dot);
        compoundShape.add(c);

        export(circle, compoundShape);
    }

    private static void export(Shape... shapes) {
        final XMLExportVisitor exportVisitor = new XMLExportVisitor();
        System.out.println(exportVisitor.export(shapes));
    }
}
