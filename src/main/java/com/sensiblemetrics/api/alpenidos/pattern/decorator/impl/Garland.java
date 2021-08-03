package com.sensiblemetrics.api.alpenidos.pattern.decorator.impl;

import com.sensiblemetrics.api.alpenidos.pattern.decorator.iface.ChristmasTree;

import static org.apache.commons.lang3.StringUtils.join;

public class Garland extends TreeDecorator {

    public Garland(final ChristmasTree tree) {
        super(tree);
    }

    @Override
    public String decorate() {
        return join(super.decorate(), this.decorateWithGarland());
    }

    private String decorateWithGarland() {
        return " with Garland";
    }
}
