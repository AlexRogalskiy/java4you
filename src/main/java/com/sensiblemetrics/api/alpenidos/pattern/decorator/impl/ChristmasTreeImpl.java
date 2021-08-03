package com.sensiblemetrics.api.alpenidos.pattern.decorator.impl;

import com.sensiblemetrics.api.alpenidos.pattern.decorator.iface.ChristmasTree;

public class ChristmasTreeImpl implements ChristmasTree {

    @Override
    public String decorate() {
        return "Christmas tree";
    }
}
