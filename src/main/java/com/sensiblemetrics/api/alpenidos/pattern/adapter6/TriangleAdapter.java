package com.sensiblemetrics.api.alpenidos.pattern.adapter6;

import com.sensiblemetrics.api.alpenidos.pattern.adapter4.Shape;
import com.sensiblemetrics.api.alpenidos.pattern.adapter5.Triangle;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
public class TriangleAdapter extends Triangle implements Shape {

    @Override
    public void draw() {
        this.drawShape();
    }

    @Override
    public void resize() {
        log.info("Triangle can't be resized. Please create new one with required values.");
    }

    @Override
    public String description() {
        return "Triangle object";
    }

    @Override
    public boolean isHide() {
        return false;
    }
}
