package com.sensiblemetrics.api.alpenidos.core.prototype2.impl;

/**
 * OrcWarlord
 */
public class OrcWarlord extends Warlord {
    private String weapon;

    public OrcWarlord(final String weapon) {
        this.weapon = weapon;
    }

    public OrcWarlord(final OrcWarlord orcWarlord) {
        this.weapon = orcWarlord.weapon;
    }

    @Override
    public OrcWarlord copy() {
        return new OrcWarlord(this);
    }

    @Override
    public String toString() {
        return "Orcish warlord attacks with " + this.weapon;
    }
}
