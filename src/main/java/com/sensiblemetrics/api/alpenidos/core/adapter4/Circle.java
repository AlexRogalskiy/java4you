package com.sensiblemetrics.api.alpenidos.core.adapter4;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Circle implements Shape {
    @Override
    public void draw() {
        log.info("Drawing Circle");
    }

    @Override
    public void resize() {
        log.info("Resizing Circle");
    }

    @Override
    public String description() {
        return "Circle object";
    }

    @Override
    public boolean isHide() {
        return false;
    }
}
