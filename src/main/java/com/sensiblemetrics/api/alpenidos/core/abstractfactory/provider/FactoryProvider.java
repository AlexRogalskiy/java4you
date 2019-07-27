package com.sensiblemetrics.api.alpenidos.core.abstractfactory.provider;

import com.sensiblemetrics.api.alpenidos.core.abstractfactory.factory.AnimalFactory;
import com.sensiblemetrics.api.alpenidos.core.abstractfactory.factory.ColorFactory;
import com.sensiblemetrics.api.alpenidos.core.abstractfactory.iface.AbstractFactory;

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
