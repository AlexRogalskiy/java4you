package com.sensiblemetrics.api.alpenidos.core.abstract_document.model;

import com.sensiblemetrics.api.alpenidos.core.abstract_document.iface.HasModel;
import com.sensiblemetrics.api.alpenidos.core.abstract_document.iface.HasParts;
import com.sensiblemetrics.api.alpenidos.core.abstract_document.iface.HasPrice;
import com.sensiblemetrics.api.alpenidos.core.abstract_document.impl.AbstractDocument;

import java.util.Map;

/**
 * Car entity
 */
public class Car extends AbstractDocument implements HasModel, HasPrice, HasParts {

    public Car(final Map<String, Object> properties) {
        super(properties);
    }
}
