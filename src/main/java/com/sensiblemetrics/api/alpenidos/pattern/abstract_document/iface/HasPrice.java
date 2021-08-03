package com.sensiblemetrics.api.alpenidos.pattern.abstract_document.iface;

import com.sensiblemetrics.api.alpenidos.pattern.abstract_document.enums.Property;

import java.util.Optional;

/**
 * HasPrice trait for static access to 'price' property
 */
public interface HasPrice extends Document {

    default Optional<Number> getPrice() {
        return Optional.ofNullable((Number) get(Property.PRICE.toString()));
    }
}
