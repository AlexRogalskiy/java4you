package com.sensiblemetrics.api.alpenidos.pattern.object_mother.impl;

import com.sensiblemetrics.api.alpenidos.pattern.object_mother.iface.Royalty;

/**
 * Defines all attributes and behaviour related to the King
 */
public class King implements Royalty {
    private boolean isDrunk = false;
    private boolean isHappy = false;

    @Override
    public void makeDrunk() {
        this.isDrunk = true;
    }

    @Override
    public void makeSober() {
        this.isDrunk = false;
    }

    @Override
    public void makeHappy() {
        this.isHappy = true;
    }

    @Override
    public void makeUnhappy() {
        this.isHappy = false;
    }

    public boolean isHappy() {
        return this.isHappy;
    }

    public boolean isDrunk() {
        return this.isDrunk;
    }

    /**
     * Method to flirt to a queen.
     *
     * @param queen Queen which should be flirted.
     */
    public void flirt(final Queen queen) {
        final boolean flirtStatus = queen.getFlirted(this);
        if (!flirtStatus) {
            this.makeUnhappy();
        } else {
            this.makeHappy();
        }
    }
}
