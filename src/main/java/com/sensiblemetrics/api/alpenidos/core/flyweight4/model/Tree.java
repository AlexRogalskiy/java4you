package com.sensiblemetrics.api.alpenidos.core.flyweight4.model;

import java.awt.Graphics;

public class Tree {

    private final int x;
    private final int y;
    private final TreeType type;

    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw(final Graphics g) {
        type.draw(g, x, y);
    }
}
