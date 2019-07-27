package com.sensiblemetrics.api.alpenidos.core.decorator;

import com.sensiblemetrics.api.alpenidos.core.decorator.iface.ChristmasTree;
import com.sensiblemetrics.api.alpenidos.core.decorator.impl.BubbleLights;
import com.sensiblemetrics.api.alpenidos.core.decorator.impl.ChristmasTreeImpl;
import com.sensiblemetrics.api.alpenidos.core.decorator.impl.Garland;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DecoratorPatternDriver {

    public static void main(String[] args) {
        // christmas tree with just one Garland
        final ChristmasTree tree1 = new Garland(new ChristmasTreeImpl());
        log.info(tree1.decorate());

        // christmas tree with two Garlands and one Bubble lights
        final ChristmasTree tree2 = new BubbleLights(new Garland(new Garland(new ChristmasTreeImpl())));
        log.info(tree2.decorate());
    }
}
