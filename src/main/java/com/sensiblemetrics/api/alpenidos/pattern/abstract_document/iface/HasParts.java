package com.sensiblemetrics.api.alpenidos.pattern.abstract_document.iface;

import com.sensiblemetrics.api.alpenidos.pattern.abstract_document.enums.Property;
import com.sensiblemetrics.api.alpenidos.pattern.abstract_document.model.Part;

import java.util.stream.Stream;

/**
 * HasParts trait for static access to 'parts' property
 */
public interface HasParts extends Document {

    default Stream<Part> getParts() {
        return children(Property.PARTS.toString(), Part::new);
    }
}
