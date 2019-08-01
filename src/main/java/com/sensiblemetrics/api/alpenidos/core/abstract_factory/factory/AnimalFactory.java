package com.sensiblemetrics.api.alpenidos.core.abstract_factory.factory;

import com.sensiblemetrics.api.alpenidos.core.abstract_factory.iface.AbstractFactory;
import com.sensiblemetrics.api.alpenidos.core.abstract_factory.iface.Animal;
import com.sensiblemetrics.api.alpenidos.core.abstract_factory.iface.Color;
import com.sensiblemetrics.api.alpenidos.core.abstract_factory.model.Dog;
import com.sensiblemetrics.api.alpenidos.core.abstract_factory.model.Duck;

public class AnimalFactory implements AbstractFactory {

    @Override
    public Animal getAnimal(final String animalType) {
        if ("Dog".equalsIgnoreCase(animalType)) {
            return new Dog();
        } else if ("Duck".equalsIgnoreCase(animalType)) {
            return new Duck();
        }
        return null;
    }

    @Override
    public Color getColor(final String color) {
        throw new UnsupportedOperationException();
    }
}
