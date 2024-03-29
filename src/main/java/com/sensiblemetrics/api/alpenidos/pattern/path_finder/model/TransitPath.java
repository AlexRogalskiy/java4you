package com.sensiblemetrics.api.alpenidos.pattern.path_finder.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * TransitPath entity
 */
@Builder
@EqualsAndHashCode
@ToString
public class TransitPath implements Serializable {

    /**
     * Default {@link List} collection of {@link TransitEdge}
     */
    private final List<TransitEdge> transitEdges;

    /**
     * Constructor.
     *
     * @param transitEdges The legs for this itinerary.
     */
    public TransitPath(final List<TransitEdge> transitEdges) {
        this.transitEdges = transitEdges;
    }

    /**
     * @return An unmodifiable list DTOs.
     */
    public List<TransitEdge> getTransitEdges() {
        return Collections.unmodifiableList(transitEdges);
    }
}
