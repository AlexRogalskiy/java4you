package com.sensiblemetrics.api.alpenidos.pattern.memento5.editor;

import com.sensiblemetrics.api.alpenidos.pattern.memento5.command.Command;
import com.sensiblemetrics.api.alpenidos.pattern.memento5.history.History;
import com.sensiblemetrics.api.alpenidos.pattern.memento5.history.Memento;
import com.sensiblemetrics.api.alpenidos.pattern.memento5.shapes.CompoundShape;
import com.sensiblemetrics.api.alpenidos.pattern.memento5.shapes.Shape;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Base64;
import javax.swing.JComponent;

public class Editor extends JComponent {

    private CompoundShape allShapes = new CompoundShape();

    private final Canvas canvas;
    private final History history;

    public Editor() {
        this.canvas = new Canvas(this);
        this.history = new History();
    }

    public void loadShapes(final Shape... shapes) {
        this.allShapes.clear();
        this.allShapes.add(shapes);
        this.canvas.refresh();
    }

    public CompoundShape getShapes() {
        return allShapes;
    }

    public void execute(Command c) {
        history.push(c, new Memento(this));
        c.execute();
    }

    public void undo() {
        if (history.undo()) {
            canvas.repaint();
        }
    }

    public void redo() {
        if (history.redo()) {
            canvas.repaint();
        }
    }

    public String backup() {
        try {
            final ByteArrayOutputStream baos = new ByteArrayOutputStream();
            final ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this.allShapes);
            oos.close();
            return Base64.getEncoder().encodeToString(baos.toByteArray());
        } catch (IOException e) {
            return "";
        }
    }

    public void restore(String state) {
        try {
            final byte[] data = Base64.getDecoder().decode(state);
            final ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
            this.allShapes = (CompoundShape) ois.readObject();
            ois.close();
        } catch (ClassNotFoundException e) {
            System.out.print("ClassNotFoundException occurred.");
        } catch (IOException e) {
            System.out.print("IOException occurred.");
        }
    }
}
