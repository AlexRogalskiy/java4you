package com.sensiblemetrics.api.alpenidos.core.prototype2.impl;

/**
 * OrcMage
 */
public class OrcMage extends Mage {
    private String weapon;

    public OrcMage(final String weapon) {
        this.weapon = weapon;
    }

    public OrcMage(final OrcMage orcMage) {
        this.weapon = orcMage.weapon;
    }

    @Override
    public OrcMage copy() {
        return new OrcMage(this);
    }

    @Override
    public String toString() {
        return "Orcish mage attacks with " + this.weapon;
    }
}
