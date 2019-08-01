package com.sensiblemetrics.api.alpenidos.core.abstract_factory;

import com.sensiblemetrics.api.alpenidos.core.abstract_factory.iface.AbstractFactory;
import com.sensiblemetrics.api.alpenidos.core.abstract_factory.iface.Animal;
import com.sensiblemetrics.api.alpenidos.core.abstract_factory.iface.Color;
import com.sensiblemetrics.api.alpenidos.core.abstract_factory.provider.FactoryProvider;

public class AbstractPatternDriver {

    public static void main(final String[] args) {
        final AbstractFactory toyAbstractFactory = FactoryProvider.getFactory("Toy");
        final Animal toy = toyAbstractFactory.getAnimal("Dog");

        final AbstractFactory colorAbstractFactory = FactoryProvider.getFactory("Color");
        final Color color = colorAbstractFactory.getColor("Brown");

        final String result = String.format("Type: {%s}, color: {%s}, sound: {%s}", toy.getType(), color.getColor(), toy.makeSound());
        System.out.println(result);
    }
}
