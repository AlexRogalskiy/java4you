package com.sensiblemetrics.api.alpenidos.core.abstractfactory.factory;

import com.sensiblemetrics.api.alpenidos.core.abstractfactory.iface.AbstractFactory;
import com.sensiblemetrics.api.alpenidos.core.abstractfactory.iface.Animal;
import com.sensiblemetrics.api.alpenidos.core.abstractfactory.iface.Color;
import com.sensiblemetrics.api.alpenidos.core.abstractfactory.model.Dog;
import com.sensiblemetrics.api.alpenidos.core.abstractfactory.model.Duck;

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
