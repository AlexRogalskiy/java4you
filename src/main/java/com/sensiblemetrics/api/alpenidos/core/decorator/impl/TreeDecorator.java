package com.sensiblemetrics.api.alpenidos.core.decorator.impl;

import com.sensiblemetrics.api.alpenidos.core.decorator.iface.ChristmasTree;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class TreeDecorator implements ChristmasTree {
    private final ChristmasTree tree;

    @Override
    public String decorate() {
        return this.tree.decorate();
    }
}
