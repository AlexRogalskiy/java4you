package com.sensiblemetrics.api.alpenidos.pattern.concrete_pattern.management;

import com.sensiblemetrics.api.alpenidos.pattern.concrete_pattern.factory.AnimalFactory;
import com.sensiblemetrics.api.alpenidos.pattern.concrete_pattern.model.Animal;

import java.lang.reflect.InvocationTargetException;

public abstract class AbstractAnimalFactory implements AnimalFactory {

    @Override
    public <A extends Animal> A createCustom(final Class<A> customAnimalClass) {
        try {
            return customAnimalClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            System.out.println("Could not instantiate animal of class " + customAnimalClass.getCanonicalName());
            e.printStackTrace();
        }

        return null;
    }
}
