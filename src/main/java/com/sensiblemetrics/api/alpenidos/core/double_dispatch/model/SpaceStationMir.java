package com.sensiblemetrics.api.alpenidos.core.double_dispatch.model;

import com.sensiblemetrics.api.alpenidos.core.double_dispatch.constants.AppConstants;
import lombok.extern.slf4j.Slf4j;

/**
 * Space station Mir game object
 */
@Slf4j
public class SpaceStationMir extends GameObject {

    public SpaceStationMir(int left, int top, int right, int bottom) {
        super(left, top, right, bottom);
    }

    @Override
    public void collision(final GameObject gameObject) {
        gameObject.collisionResolve(this);
    }

    @Override
    public void collisionResolve(final FlamingAsteroid asteroid) {
        log.info(AppConstants.HITS, " {} is damaged! {} is set on fire!", asteroid.getClass().getSimpleName(), this.getClass().getSimpleName(), this.getClass().getSimpleName(), this.getClass().getSimpleName());
        this.setDamaged(true);
        this.setOnFire(true);
    }

    @Override
    public void collisionResolve(final Meteoroid meteoroid) {
        log.info(AppConstants.HITS, " {} is damaged!", meteoroid.getClass().getSimpleName(), this.getClass().getSimpleName(), this.getClass().getSimpleName());
        this.setDamaged(true);
    }

    @Override
    public void collisionResolve(final SpaceStationMir mir) {
        log.info(AppConstants.HITS, " {} is damaged!", mir.getClass().getSimpleName(), this.getClass().getSimpleName(), this.getClass().getSimpleName());
        this.setDamaged(true);
    }

    @Override
    public void collisionResolve(final SpaceStationLess iss) {
        log.info(AppConstants.HITS, " {} is damaged!", iss.getClass().getSimpleName(), this.getClass().getSimpleName(), this.getClass().getSimpleName());
        this.setDamaged(true);
    }
}
