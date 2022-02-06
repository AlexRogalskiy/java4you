package com.sensiblemetrics.api.alpenidos.pattern.concrete_pattern.management;

import com.sensiblemetrics.api.alpenidos.pattern.concrete_pattern.factory.AnimalFactory;
import com.sensiblemetrics.api.alpenidos.pattern.concrete_pattern.factory.AnimalFactoryProvider;

public class CuteAnimalFactoryProvider implements AnimalFactoryProvider {
    @Override
    public AnimalFactory get() {
        return new CuteAnimalFactory();
    }
}
