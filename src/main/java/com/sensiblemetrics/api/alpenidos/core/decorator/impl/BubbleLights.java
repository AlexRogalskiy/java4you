package com.sensiblemetrics.api.alpenidos.core.decorator.impl;

import com.sensiblemetrics.api.alpenidos.core.decorator.iface.ChristmasTree;

import static org.apache.commons.lang3.StringUtils.join;

public class BubbleLights extends TreeDecorator {

    public BubbleLights(final ChristmasTree tree) {
        super(tree);
    }

    @Override
    public String decorate() {
        return join(super.decorate(), this.decorateWithBubbleLights());
    }

    private String decorateWithBubbleLights() {
        return " with Bubble Lights";
    }
}
