package com.sensiblemetrics.api.alpenidos.pattern.spatial_partition.impl;

import com.sensiblemetrics.api.alpenidos.pattern.spatial_partition.model.Bubble;
import com.sensiblemetrics.api.alpenidos.pattern.spatial_partition.model.Point;
import com.sensiblemetrics.api.alpenidos.pattern.spatial_partition.model.QuadTree;
import com.sensiblemetrics.api.alpenidos.pattern.spatial_partition.model.Rect;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * This class extends the generic SpatialPartitionPatternLoader abstract class and is used in
 * our example to keep track of all the bubbles that collide, pop and stay un-popped.
 */
public class SpatialPartitionBubbles extends SpatialPartitionGeneric<Bubble> {

    public SpatialPartitionBubbles(final Hashtable<Integer, Bubble> bubbles, final QuadTree qTree) {
        super(bubbles, qTree);
    }

    public void handleCollisionsUsingQt(final Bubble b) {
        //finding points within area of a square drawn with centre same as centre of bubble and length = radius of bubble
        final Rect rect = new Rect(b.getX(), b.getY(), 2 * b.getRadius(), 2 * b.getRadius());
        final List<Point> quadTreeQueryResult = new ArrayList<>();
        this.getQTree().query(rect, quadTreeQueryResult);
        //handling these collisions
        b.handleCollision(quadTreeQueryResult, this.getPlayerPositions());
    }
}
