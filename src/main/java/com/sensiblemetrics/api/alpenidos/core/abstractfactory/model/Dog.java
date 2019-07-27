package com.sensiblemetrics.api.alpenidos.core.abstractfactory.model;

import com.sensiblemetrics.api.alpenidos.core.abstractfactory.iface.Animal;

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
