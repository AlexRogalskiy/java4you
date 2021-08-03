package com.sensiblemetrics.api.alpenidos.pattern.abstract_factory.model;

import com.sensiblemetrics.api.alpenidos.pattern.abstract_factory.iface.Animal;

public class Duck implements Animal {

    @Override
    public String getType() {
        return "Duck";
    }

    @Override
    public String makeSound() {
        return "Squeks";
    }

}
