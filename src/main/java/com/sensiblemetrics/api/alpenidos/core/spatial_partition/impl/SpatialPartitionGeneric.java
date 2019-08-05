package com.sensiblemetrics.api.alpenidos.core.spatial_partition.impl;

import com.sensiblemetrics.api.alpenidos.core.spatial_partition.model.QuadTree;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Hashtable;

/**
 * This abstract class has 2 fields, one of which is a hashtable containing all objects
 * that currently exist on the field and a quadtree which keeps track of locations.
 *
 * @param <T> T will be type of object (that extends Point)
 */
@Getter
@RequiredArgsConstructor
public abstract class SpatialPartitionGeneric<T> {
    private final Hashtable<Integer, T> playerPositions;
    private final QuadTree qTree;

    /**
     * handles collisions for object obj using quadtree
     *
     * @param obj is the object for which collisions need to be checked
     */
    abstract void handleCollisionsUsingQt(final T obj);
}
