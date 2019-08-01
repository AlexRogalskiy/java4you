package com.sensiblemetrics.api.alpenidos.core.abstract_factory.provider;

import com.sensiblemetrics.api.alpenidos.core.abstract_factory.factory.AnimalFactory;
import com.sensiblemetrics.api.alpenidos.core.abstract_factory.factory.ColorFactory;
import com.sensiblemetrics.api.alpenidos.core.abstract_factory.iface.AbstractFactory;

public class FactoryProvider {

    public static AbstractFactory getFactory(final String choice) {
        if ("Toy".equalsIgnoreCase(choice)) {
            return new AnimalFactory();
        } else if ("Color".equalsIgnoreCase(choice)) {
            return new ColorFactory();
        }
        return null;
    }
}
