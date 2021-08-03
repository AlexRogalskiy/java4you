package com.sensiblemetrics.api.alpenidos.pattern.spatial_partition.model;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

/**
 * The quadtree data structure is being used to keep track of the objects' locations.
 * It has the insert(Point) and query(range) methods to insert a new object and find
 * the objects within a certain (rectangular) range respectively.
 */
public class QuadTree {
    private Rect boundary;
    private int capacity;
    private boolean divided;
    private Hashtable<Integer, Point> points;
    private QuadTree northwest;
    private QuadTree northeast;
    private QuadTree southwest;
    private QuadTree southeast;

    public QuadTree(final Rect boundary, final int capacity) {
        this.boundary = boundary;
        this.capacity = capacity;
        this.divided = false;
        this.points = new Hashtable<>();
        this.northwest = null;
        this.northeast = null;
        this.southwest = null;
        this.southeast = null;
    }

    public void insert(final Point p) {
        if (this.boundary.contains(p)) {
            if (this.points.size() < this.capacity) {
                points.put(p.getId(), p);
            } else {
                if (!this.divided) {
                    this.divide();
                }
                if (this.northwest.boundary.contains(p)) {
                    this.northwest.insert(p);
                } else if (this.northeast.boundary.contains(p)) {
                    this.northeast.insert(p);
                } else if (this.southwest.boundary.contains(p)) {
                    this.southwest.insert(p);
                } else if (this.southeast.boundary.contains(p)) {
                    this.southeast.insert(p);
                }
            }
        }
    }

    public void divide() {
        final Rect nw = new Rect(
            this.boundary.getX() - this.boundary.getWidth() / 4,
            this.boundary.getY() + this.boundary.getHeight() / 4,
            this.boundary.getWidth() / 2,
            this.boundary.getHeight() / 2
        );
        this.northwest = new QuadTree(nw, this.capacity);

        final Rect ne = new Rect(
            this.boundary.getX() + this.boundary.getWidth() / 4,
            this.boundary.getY() + this.boundary.getHeight() / 4,
            this.boundary.getWidth() / 2,
            this.boundary.getHeight() / 2
        );
        this.northeast = new QuadTree(ne, this.capacity);

        final Rect sw = new Rect(
            this.boundary.getX() - this.boundary.getWidth() / 4,
            this.boundary.getY() - this.boundary.getHeight() / 4,
            this.boundary.getWidth() / 2,
            this.boundary.getHeight() / 2);
        this.southwest = new QuadTree(sw, this.capacity);

        final Rect se = new Rect(
            this.boundary.getX() + this.boundary.getWidth() / 4,
            this.boundary.getY() - this.boundary.getHeight() / 4,
            this.boundary.getWidth() / 2,
            this.boundary.getHeight() / 2);
        this.southeast = new QuadTree(se, this.capacity);

        this.divided = true;
    }

    public List<Point> query(final Rect r, final List<Point> relevantPoints) {
        //could also be a circle instead of a rectangle
        if (this.boundary.intersects(r)) {
            for (final Enumeration<Integer> e = this.points.keys(); e.hasMoreElements(); ) {
                final Integer i = e.nextElement();
                if (r.contains(this.points.get(i))) {
                    relevantPoints.add(this.points.get(i));
                }
            }
            if (this.divided) {
                this.northwest.query(r, relevantPoints);
                this.northeast.query(r, relevantPoints);
                this.southwest.query(r, relevantPoints);
                this.southeast.query(r, relevantPoints);
            }
        }
        return relevantPoints;
    }
}
