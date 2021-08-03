package com.sensiblemetrics.api.alpenidos.pattern.servant.impl;

import com.sensiblemetrics.api.alpenidos.pattern.servant.iface.Royalty;

/**
 * Queen
 */
public class Queen implements Royalty {

    private boolean isDrunk = true;
    private boolean isHungry;
    private boolean isHappy;
    private boolean isFlirty = true;
    private boolean complimentReceived;

    @Override
    public void getFed() {
        this.isHungry = false;
    }

    @Override
    public void getDrink() {
        this.isDrunk = true;
    }

    public void receiveCompliments() {
        this.complimentReceived = true;
    }

    @Override
    public void changeMood() {
        if (this.complimentReceived && this.isFlirty && this.isDrunk && !this.isHungry) {
            this.isHappy = true;
        }
    }

    @Override
    public boolean getMood() {
        return this.isHappy;
    }

    public void setFlirtiness(boolean flirty) {
        this.isFlirty = flirty;
    }

}
