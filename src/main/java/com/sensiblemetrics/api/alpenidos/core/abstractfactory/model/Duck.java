package com.sensiblemetrics.api.alpenidos.core.abstractfactory.model;

import com.sensiblemetrics.api.alpenidos.core.abstractfactory.iface.Animal;

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
