package com.sensiblemetrics.api.alpenidos.pattern.abstract_document;

import com.google.common.collect.ImmutableMap;
import com.sensiblemetrics.api.alpenidos.pattern.abstract_document.enums.Property;
import com.sensiblemetrics.api.alpenidos.pattern.abstract_document.iface.Document;
import com.sensiblemetrics.api.alpenidos.pattern.abstract_document.impl.AbstractDocument;
import com.sensiblemetrics.api.alpenidos.pattern.abstract_document.model.Car;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Map;

/**
 * The Abstract Document pattern enables handling additional, non-static
 * properties. This pattern uses concept of traits to enable type safety and
 * separate properties of different classes into set of interfaces.
 * <p>
 * <p>
 * In Abstract Document pattern,({@link AbstractDocument}) fully implements
 * {@link Document}) interface. Traits are then defined to enable access to
 * properties in usual, static way.
 */
@Slf4j
public class AbstractDocumentPatternLoader {

    /**
     * Executes the AcyclicVisitorPatternLoader
     */
    public AbstractDocumentPatternLoader() {
        log.info("Constructing parts and car");
        final Map<String, Object> carProperties = ImmutableMap.<String, Object>builder()
            .put(Property.MODEL.toString(), "300SL")
            .put(Property.PRICE.toString(), 10000L)
            .build();

        final Map<String, Object> wheelProperties = ImmutableMap.<String, Object>builder()
            .put(Property.TYPE.toString(), "wheel")
            .put(Property.MODEL.toString(), "15C")
            .put(Property.PRICE.toString(), 100L)
            .build();

        final Map<String, Object> doorProperties = ImmutableMap.<String, Object>builder()
            .put(Property.TYPE.toString(), "door")
            .put(Property.MODEL.toString(), "Lambo")
            .put(Property.PRICE.toString(), 300L)
            .build();

        carProperties.put(Property.PARTS.toString(), Arrays.asList(wheelProperties, doorProperties));

        final Car car = new Car(carProperties);
        log.info("Here is our car:");
        log.info("-> model: {}", car.getModel().get());
        log.info("-> price: {}", car.getPrice().get());
        log.info("-> parts: ");
        car.getParts().forEach(p -> log.info("\t{}/{}/{}", p.getType().get(), p.getModel().get(), p.getPrice().get()));
    }

    /**
     * Program entry point
     *
     * @param args command line args
     */
    public static void main(final String[] args) {
        new AbstractDocumentPatternLoader();
    }
}
