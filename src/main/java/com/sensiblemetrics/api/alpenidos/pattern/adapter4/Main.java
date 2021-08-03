package com.sensiblemetrics.api.alpenidos.pattern.adapter4;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(final String[] args) {
        log.info("Creating drawing of shapes...");
        final Drawing drawing = new Drawing();
        drawing.addShape(new Rectangle());
        drawing.addShape(new Circle());

        log.info("Drawing...");
        drawing.draw();

        log.info("Resizing...");
        drawing.resize();
    }
}
