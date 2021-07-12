package com.sensiblemetrics.api.alpenidos.core.memento5.command;

import com.sensiblemetrics.api.alpenidos.core.memento5.editor.Editor;
import com.sensiblemetrics.api.alpenidos.core.memento5.shapes.Shape;
import java.awt.Color;

public class ColorCommand implements Command {

    private final Editor editor;
    private final Color color;

    public ColorCommand(Editor editor, Color color) {
        this.editor = editor;
        this.color = color;
    }

    @Override
    public String getName() {
        return "Colorize: " + color.toString();
    }

    @Override
    public void execute() {
        for (Shape child : editor.getShapes().getSelected()) {
            child.setColor(color);
        }
    }
}
