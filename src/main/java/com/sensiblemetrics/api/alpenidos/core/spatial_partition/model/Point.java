package com.sensiblemetrics.api.alpenidos.core.spatial_partition.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Hashtable;
import java.util.List;

/**
 * The abstract Point class which will be extended by any object in the field
 * whose location has to be kept track of. Defined by x,y coordinates and an id
 * for easy hashing into hashtable.
 *
 * @param <T> T will be type subclass
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public abstract class Point<T> {
    private final int id;
    private int x;
    private int y;

    /**
     * defines how the object moves
     */
    abstract void move();

    /**
     * defines conditions for interacting with an object obj
     *
     * @param obj is another object on field which also extends Point
     * @return whether the object can interact with the other or not
     */
    abstract boolean touches(final T obj);

    /**
     * handling interactions/collisions with other objects
     *
     * @param pointsToCheck contains the objects which need to be checked
     * @param allPoints     contains hashtable of all points on field at this time
     */
    abstract void handleCollision(final List<Point> pointsToCheck, final Hashtable<Integer, T> allPoints);
}
