package com.sensiblemetrics.api.alpenidos.pattern.double_dispatch.model;

/**
 * Flaming asteroid game object
 */
public class FlamingAsteroid extends Meteoroid {

    public FlamingAsteroid(int left, int top, int right, int bottom) {
        super(left, top, right, bottom);
        this.setOnFire(true);
    }

    @Override
    public void collision(final GameObject gameObject) {
        gameObject.collisionResolve(this);
    }
}
