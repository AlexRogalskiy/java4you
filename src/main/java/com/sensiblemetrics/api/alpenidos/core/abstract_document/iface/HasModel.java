package com.sensiblemetrics.api.alpenidos.core.abstract_document.iface;

import com.sensiblemetrics.api.alpenidos.core.abstract_document.enums.Property;

import java.util.Optional;

/**
 * HasModel trait for static access to 'model' property
 */
public interface HasModel extends Document {

    default Optional<String> getModel() {
        return Optional.ofNullable((String) get(Property.MODEL.toString()));
    }
}
