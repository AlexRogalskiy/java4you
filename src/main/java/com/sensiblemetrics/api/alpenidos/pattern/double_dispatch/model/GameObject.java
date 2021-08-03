package com.sensiblemetrics.api.alpenidos.pattern.double_dispatch.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Game objects have coordinates and some other status information.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class GameObject extends Rectangle {
    private boolean damaged;
    private boolean onFire;

    public GameObject(int left, int top, int right, int bottom) {
        super(left, top, right, bottom);
    }

    @Override
    public String toString() {
        return String.format("%s at %s damaged=%b onFire=%b", this.getClass().getSimpleName(), super.toString(), this.isDamaged(), this.isOnFire());
    }

    public abstract void collision(final GameObject gameObject);

    public abstract void collisionResolve(final FlamingAsteroid asteroid);

    public abstract void collisionResolve(final Meteoroid meteoroid);

    public abstract void collisionResolve(final SpaceStationMir mir);

    public abstract void collisionResolve(final SpaceStationLess iss);
}
