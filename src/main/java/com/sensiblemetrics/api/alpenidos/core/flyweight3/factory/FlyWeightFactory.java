package com.sensiblemetrics.api.alpenidos.core.flyweight3.factory;

import com.sensiblemetrics.api.alpenidos.core.flyweight3.impl.ConcreteFlyWeight;
import com.sensiblemetrics.api.alpenidos.core.flyweight3.impl.FlyWeight;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class FlyWeightFactory {
    private static final ConcurrentHashMap<String, FlyWeight> allFlyWeight = new ConcurrentHashMap<String, FlyWeight>();

    public static FlyWeight getFlyWeight(final String name) {
        if (allFlyWeight.get(name) == null) {
            synchronized (allFlyWeight) {
                if (allFlyWeight.get(name) == null) {
                    log.info("Instance of name = {} does not exist, creating it");
                    final FlyWeight flyWeight = new ConcreteFlyWeight(name);
                    log.info("Instance of name = {} created");
                    allFlyWeight.put(name, flyWeight);
                }
            }
        }
        return allFlyWeight.get(name);
    }
}
