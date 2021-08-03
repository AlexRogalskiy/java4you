package com.sensiblemetrics.api.alpenidos.pattern.flyweight4.model;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

public class Forest extends JFrame {

    private final List<Tree> trees = new ArrayList<>();

    public void plantTree(int x, int y, String name, Color color, String otherTreeData) {
        final TreeType type = TreeFactory.getTreeType(name, color, otherTreeData);
        final Tree tree = new Tree(x, y, type);
        this.trees.add(tree);
    }

    @Override
    public void paint(Graphics graphics) {
        for (final Tree tree : this.trees) {
            tree.draw(graphics);
        }
    }
}
