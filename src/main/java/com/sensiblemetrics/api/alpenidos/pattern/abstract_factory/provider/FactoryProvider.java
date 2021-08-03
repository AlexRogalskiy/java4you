package com.sensiblemetrics.api.alpenidos.pattern.abstract_factory.provider;

import com.sensiblemetrics.api.alpenidos.pattern.abstract_factory.enums.FactoryType;
import com.sensiblemetrics.api.alpenidos.pattern.abstract_factory.factory.AnimalFactory;
import com.sensiblemetrics.api.alpenidos.pattern.abstract_factory.factory.ColorFactory;
import com.sensiblemetrics.api.alpenidos.pattern.abstract_factory.iface.AbstractFactory;

public class FactoryProvider {

    public static AbstractFactory getFactory(final String choice) {
        if ("Toy".equalsIgnoreCase(choice)) {
            return new AnimalFactory();
        } else if ("Color".equalsIgnoreCase(choice)) {
            return new ColorFactory();
        }
        return null;
    }

    public static AbstractFactory getFactory(final FactoryType factoryType) {
        switch (factoryType) {
            case ANIMAL:
                return new AnimalFactory();
            case COLOR:
                return new ColorFactory();
            default:
                throw new IllegalArgumentException(String.format("Factory type {%s} is not supported", factoryType));
        }
    }
}
