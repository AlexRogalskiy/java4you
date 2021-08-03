package com.sensiblemetrics.api.alpenidos.pattern.adapter4;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@NoArgsConstructor
public class Drawing {
    private final List<Shape> shapes = new ArrayList<>();

    public void addShape(Shape shape) {
        this.shapes.add(shape);
    }

    public List<Shape> getShapes() {
        return new ArrayList<>(this.shapes);
    }

    public void draw() {
        if (this.shapes.isEmpty()) {
            log.info("Nothing to draw!");
        } else {
            this.shapes.stream().forEach(shape -> shape.draw());
        }
    }

    public void resize() {
        if (this.shapes.isEmpty()) {
            log.info("Nothing to resize!");
        } else {
            this.shapes.stream().forEach(shape -> shape.resize());
        }
    }
}
