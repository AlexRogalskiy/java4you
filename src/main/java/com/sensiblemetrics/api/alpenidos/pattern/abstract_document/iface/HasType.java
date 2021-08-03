package com.sensiblemetrics.api.alpenidos.pattern.abstract_document.iface;

import com.sensiblemetrics.api.alpenidos.pattern.abstract_document.enums.Property;

import java.util.Optional;

/**
 * HasType trait for static access to 'type' property
 */
public interface HasType extends Document {

    default Optional<String> getType() {
        return Optional.ofNullable((String) get(Property.TYPE.toString()));
    }
}
