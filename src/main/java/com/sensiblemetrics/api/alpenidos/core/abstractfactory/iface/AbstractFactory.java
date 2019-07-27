package com.sensiblemetrics.api.alpenidos.core.abstractfactory.iface;

public interface AbstractFactory {

    Animal getAnimal(final String toyType);

    Color getColor(final String colorType);
}
