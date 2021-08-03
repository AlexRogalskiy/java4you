package com.sensiblemetrics.api.alpenidos.pattern.flyweight3.client;

import com.sensiblemetrics.api.alpenidos.pattern.flyweight3.factory.FlyWeightFactory;
import com.sensiblemetrics.api.alpenidos.pattern.flyweight3.impl.FlyWeight;

public class FlyWeightClient {

    public static void main(final String[] args) {
        final FlyWeight bmw1 = FlyWeightFactory.getFlyWeight("bmw");
        final FlyWeight bmw2 = FlyWeightFactory.getFlyWeight("bmw");
        final FlyWeight bmw3 = FlyWeightFactory.getFlyWeight("bmw");

        bmw1.action("start");
        bmw2.action("stop");
        bmw3.action("boost");
    }
}
