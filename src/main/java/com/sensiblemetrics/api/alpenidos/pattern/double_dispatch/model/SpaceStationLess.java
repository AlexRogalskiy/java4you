package com.sensiblemetrics.api.alpenidos.pattern.double_dispatch.model;

/**
 * Space station ISS game object
 */
public class SpaceStationLess extends SpaceStationMir {

    public SpaceStationLess(int left, int top, int right, int bottom) {
        super(left, top, right, bottom);
    }

    @Override
    public void collision(final GameObject gameObject) {
        gameObject.collisionResolve(this);
    }
}
