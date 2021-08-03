package com.sensiblemetrics.api.alpenidos.pattern.abstract_document.model;

import com.sensiblemetrics.api.alpenidos.pattern.abstract_document.iface.HasModel;
import com.sensiblemetrics.api.alpenidos.pattern.abstract_document.iface.HasPrice;
import com.sensiblemetrics.api.alpenidos.pattern.abstract_document.iface.HasType;
import com.sensiblemetrics.api.alpenidos.pattern.abstract_document.impl.AbstractDocument;

import java.util.Map;

/**
 * Part entity
 */
public class Part extends AbstractDocument implements HasType, HasModel, HasPrice {

    public Part(final Map<String, Object> properties) {
        super(properties);
    }
}
