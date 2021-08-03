package com.sensiblemetrics.api.alpenidos.pattern.prototype2.impl;

/**
 * OrcBeast
 */
public class OrcBeast extends Beast {
    private String weapon;

    public OrcBeast(final String weapon) {
        this.weapon = weapon;
    }

    public OrcBeast(final OrcBeast orcBeast) {
        this.weapon = orcBeast.weapon;
    }

    @Override
    public Beast copy() {
        return new OrcBeast(this);
    }

    @Override
    public String toString() {
        return "Orcish wolf attacks with " + this.weapon;
    }
}
