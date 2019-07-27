package com.sensiblemetrics.api.alpenidos.core.decorator.impl;

import com.sensiblemetrics.api.alpenidos.core.decorator.iface.ChristmasTree;

public class ChristmasTreeImpl implements ChristmasTree {

    @Override
    public String decorate() {
        return "Christmas tree";
    }
}
