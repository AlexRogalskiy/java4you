package com.sensiblemetrics.api.alpenidos.core.abstract_factory.factory;

import com.sensiblemetrics.api.alpenidos.core.abstract_factory.iface.AbstractFactory;
import com.sensiblemetrics.api.alpenidos.core.abstract_factory.iface.Animal;
import com.sensiblemetrics.api.alpenidos.core.abstract_factory.iface.Color;
import com.sensiblemetrics.api.alpenidos.core.abstract_factory.model.Brown;
import com.sensiblemetrics.api.alpenidos.core.abstract_factory.model.White;

public class ColorFactory implements AbstractFactory {

    @Override
    public Color getColor(final String colorType) {
        if ("Brown".equalsIgnoreCase(colorType)) {
            return new Brown();
        } else if ("White".equalsIgnoreCase(colorType)) {
            return new White();
        }
        return null;
    }

    @Override
    public Animal getAnimal(final String toyType) {
        throw new UnsupportedOperationException();
    }

}
