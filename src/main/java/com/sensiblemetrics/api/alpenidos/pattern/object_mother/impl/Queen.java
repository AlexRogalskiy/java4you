package com.sensiblemetrics.api.alpenidos.pattern.object_mother.impl;

import com.sensiblemetrics.api.alpenidos.pattern.object_mother.iface.Royalty;

/**
 * Defines all attributes and behaviour related to the Queen
 */
public class Queen implements Royalty {
    private boolean isDrunk = false;
    private boolean isHappy = false;
    private boolean isFlirty = false;

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

    public boolean isFlirty() {
        return this.isFlirty;
    }

    public void setFlirtiness(final boolean flirtiness) {
        this.isFlirty = flirtiness;
    }

    /**
     * Method which is called when the king is flirting to a queen.
     *
     * @param king King who initialized the flirt.
     * @return A value which describes if the flirt was successful or not.
     */
    public boolean getFlirted(final King king) {
        if (this.isFlirty && king.isHappy() && !king.isDrunk()) {
            return true;
        }
        return false;
    }
}
