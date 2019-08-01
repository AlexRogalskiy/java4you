package com.sensiblemetrics.api.alpenidos.core.abstract_factory.model;

import com.sensiblemetrics.api.alpenidos.core.abstract_factory.iface.Animal;

public class Dog implements Animal {

    @Override
    public String getType() {
        return "Dog";
    }

    @Override
    public String makeSound() {
        return "Barks";
    }

}
