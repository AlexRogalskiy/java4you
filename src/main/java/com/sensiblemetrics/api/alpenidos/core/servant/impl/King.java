package com.sensiblemetrics.api.alpenidos.core.servant.impl;

import com.sensiblemetrics.api.alpenidos.core.servant.iface.Royalty;

/**
 * King
 */
public class King implements Royalty {

    private boolean isDrunk;
    private boolean isHungry = true;
    private boolean isHappy;
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
        if (!this.isHungry && this.isDrunk) {
            this.isHappy = true;
        }
        if (this.complimentReceived) {
            this.isHappy = false;
        }
    }

    @Override
    public boolean getMood() {
        return this.isHappy;
    }
}
