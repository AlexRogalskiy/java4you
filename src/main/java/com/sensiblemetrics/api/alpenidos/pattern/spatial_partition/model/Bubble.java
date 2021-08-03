package com.sensiblemetrics.api.alpenidos.pattern.spatial_partition.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Hashtable;
import java.util.List;
import java.util.Random;

/**
 * Bubble class extends Point. In this example, we create several bubbles in the field,
 * let them move and keep track of which ones have popped and which ones remain.
 */
@Slf4j
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Bubble extends Point<Bubble> {
    private final int radius;

    public Bubble(int x, int y, int id, int radius) {
        super(x, y, id);
        this.radius = radius;
    }

    public void move() {
        final Random rand = new Random();
        //moves by 1 unit in either direction
        this.setX(this.getX() + rand.nextInt(3) - 1);
        this.setY(this.getY() + rand.nextInt(3) - 1);
    }

    public boolean touches(final Bubble b) {
        //distance between them is greater than sum of radii (both sides of equation squared)
        return (this.getX() - b.getX()) * (this.getX() - b.getX()) + (this.getY() - b.getY()) * (this.getY() - b.getY()) <= (this.radius + b.radius) * (this.radius + b.radius);
    }

    public void pop(final Hashtable<Integer, Bubble> allBubbles) {
        log.info("Bubble " + this.getId() + " popped at (" + this.getX() + "," + this.getY() + ")!");
        allBubbles.remove(this.getId());
    }

    public void handleCollision(final List<Point> bubblesToCheck, final Hashtable<Integer, Bubble> allBubbles) {
        boolean toBePopped = false; //if any other bubble collides with it, made true
        for (int i = 0; i < bubblesToCheck.size(); i++) {
            Integer otherId = bubblesToCheck.get(i).getId();
            if (allBubbles.get(otherId) != null && //the bubble hasn't been popped yet
                this.getId() != otherId && //the two bubbles are not the same
                this.touches(allBubbles.get(otherId))) { //the bubbles touch
                allBubbles.get(otherId).pop(allBubbles);
                toBePopped = true;
            }
        }
        if (toBePopped) {
            this.pop(allBubbles);
        }
    }
}
