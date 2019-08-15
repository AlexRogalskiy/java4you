package com.sensiblemetrics.api.alpenidos.core.adapter4;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Rectangle implements Shape {
    @Override
    public void draw() {
        log.info("Drawing Rectangle");
    }

    @Override
    public void resize() {
        log.info("Resizing Rectangle");
    }

    @Override
    public String description() {
        return "Rectangle object";
    }

    @Override
    public boolean isHide() {
        return false;
    }
}
