package com.sensiblemetrics.api.alpenidos.core.memento5;

import com.sensiblemetrics.api.alpenidos.core.memento5.editor.Editor;
import com.sensiblemetrics.api.alpenidos.core.memento5.shapes.Circle;
import com.sensiblemetrics.api.alpenidos.core.memento5.shapes.CompoundShape;
import com.sensiblemetrics.api.alpenidos.core.memento5.shapes.Dot;
import com.sensiblemetrics.api.alpenidos.core.memento5.shapes.Rectangle;
import java.awt.Color;

public class Demo {

    public static void main(String[] args) {
        final Editor editor = new Editor();
        editor.loadShapes(
            new Circle(10, 10, 10, Color.BLUE),

            new CompoundShape(
                new Circle(110, 110, 50, Color.RED),
                new Dot(160, 160, Color.RED)
            ),

            new CompoundShape(
                new Rectangle(250, 250, 100, 100, Color.GREEN),
                new Dot(240, 240, Color.GREEN),
                new Dot(240, 360, Color.GREEN),
                new Dot(360, 360, Color.GREEN),
                new Dot(360, 240, Color.GREEN)
            )
        );
    }
}
