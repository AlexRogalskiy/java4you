package com.sensiblemetrics.api.alpenidos.core.double_dispatch.model;

import com.sensiblemetrics.api.alpenidos.core.double_dispatch.constants.AppConstants;
import lombok.extern.slf4j.Slf4j;

/**
 * Meteoroid game object
 */
@Slf4j
public class Meteoroid extends GameObject {

    public Meteoroid(int left, int top, int right, int bottom) {
        super(left, top, right, bottom);
    }

    @Override
    public void collision(final GameObject gameObject) {
        gameObject.collisionResolve(this);
    }

    @Override
    public void collisionResolve(final FlamingAsteroid asteroid) {
        log.info(AppConstants.HITS, asteroid.getClass().getSimpleName(), this.getClass().getSimpleName());
    }

    @Override
    public void collisionResolve(final Meteoroid meteoroid) {
        log.info(AppConstants.HITS, meteoroid.getClass().getSimpleName(), this.getClass().getSimpleName());
    }

    @Override
    public void collisionResolve(final SpaceStationMir mir) {
        log.info(AppConstants.HITS, mir.getClass().getSimpleName(), this.getClass().getSimpleName());
    }

    @Override
    public void collisionResolve(final SpaceStationLess iss) {
        log.info(AppConstants.HITS, iss.getClass().getSimpleName(), this.getClass().getSimpleName());
    }
}
