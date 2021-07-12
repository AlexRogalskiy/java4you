package com.sensiblemetrics.api.alpenidos.core.visitor5.management;

import com.sensiblemetrics.api.alpenidos.core.visitor5.model.Circle;
import com.sensiblemetrics.api.alpenidos.core.visitor5.model.CompoundShape;
import com.sensiblemetrics.api.alpenidos.core.visitor5.model.Dot;
import com.sensiblemetrics.api.alpenidos.core.visitor5.model.Rectangle;
import com.sensiblemetrics.api.alpenidos.core.visitor5.model.Shape;

public class XMLExportVisitor implements Visitor {

    public String export(final Shape... args) {
        final StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>" + "\n");
        for (final Shape shape : args) {
            sb.append(shape.accept(this)).append("\n");
        }
        return sb.toString();
    }

    public String visitDot(final Dot d) {
        return "<dot>" + "\n" +
            "    <id>" + d.getId() + "</id>" + "\n" +
            "    <x>" + d.getX() + "</x>" + "\n" +
            "    <y>" + d.getY() + "</y>" + "\n" +
            "</dot>";
    }

    public String visitCircle(final Circle c) {
        return "<circle>" + "\n" +
            "    <id>" + c.getId() + "</id>" + "\n" +
            "    <x>" + c.getX() + "</x>" + "\n" +
            "    <y>" + c.getY() + "</y>" + "\n" +
            "    <radius>" + c.getRadius() + "</radius>" + "\n" +
            "</circle>";
    }

    public String visitRectangle(final Rectangle r) {
        return "<rectangle>" + "\n" +
            "    <id>" + r.getId() + "</id>" + "\n" +
            "    <x>" + r.getX() + "</x>" + "\n" +
            "    <y>" + r.getY() + "</y>" + "\n" +
            "    <width>" + r.getWidth() + "</width>" + "\n" +
            "    <height>" + r.getHeight() + "</height>" + "\n" +
            "</rectangle>";
    }

    public String visitCompoundGraphic(final CompoundShape cg) {
        return "<compound_graphic>" + "\n" +
            "   <id>" + cg.getId() + "</id>" + "\n" +
            _visitCompoundGraphic(cg) +
            "</compound_graphic>";
    }

    private String _visitCompoundGraphic(final CompoundShape cg) {
        final StringBuilder sb = new StringBuilder();
        for (final Shape shape : cg.children) {
            String obj = shape.accept(this);
            // Proper indentation for sub-objects.
            obj = "    " + obj.replace("\n", "\n    ") + "\n";
            sb.append(obj);
        }

        return sb.toString();
    }
}
