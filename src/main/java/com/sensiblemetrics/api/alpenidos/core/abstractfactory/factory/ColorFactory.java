package com.sensiblemetrics.api.alpenidos.core.abstractfactory.factory;

import com.sensiblemetrics.api.alpenidos.core.abstractfactory.iface.AbstractFactory;
import com.sensiblemetrics.api.alpenidos.core.abstractfactory.iface.Animal;
import com.sensiblemetrics.api.alpenidos.core.abstractfactory.iface.Color;
import com.sensiblemetrics.api.alpenidos.core.abstractfactory.model.Brown;
import com.sensiblemetrics.api.alpenidos.core.abstractfactory.model.White;

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
