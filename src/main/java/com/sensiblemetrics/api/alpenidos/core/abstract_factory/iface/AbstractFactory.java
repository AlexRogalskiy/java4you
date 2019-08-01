package com.sensiblemetrics.api.alpenidos.core.abstract_factory.iface;

public interface AbstractFactory {

    Animal getAnimal(final String toyType);

    Color getColor(final String colorType);
}
