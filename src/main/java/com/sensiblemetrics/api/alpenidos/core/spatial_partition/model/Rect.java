package com.sensiblemetrics.api.alpenidos.core.spatial_partition.model;

import lombok.Data;

/**
 * The Rect class helps in defining the boundary of the quadtree and is also used to
 * define the range within which objects need to be found in our example.
 */
@Data
public class Rect {
    private final int x;
    private final int y;
    private final int width;
    private final int height;

    public boolean contains(final Point p) {
        return p.getX() >= this.x - this.width / 2 && p.getX() <= this.x + this.width / 2
            && p.getY() >= this.y - this.height / 2 && p.getY() <= this.y + this.height / 2;
    }

    public boolean intersects(final Rect other) {
        return !(this.x + this.width / 2 <= other.x - other.width / 2
            || this.x - this.width / 2 >= other.x + other.width / 2
            || this.y + this.height / 2 <= other.y - other.height / 2
            || this.y - this.height / 2 >= other.y + other.height / 2);
    }
}
