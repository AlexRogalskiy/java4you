package com.sensiblemetrics.api.alpenidos.core.prototype2.impl;

/**
 * ElfWarlord
 */
public class ElfWarlord extends Warlord {
    private String helpType;

    public ElfWarlord(final String helpType) {
        this.helpType = helpType;
    }

    public ElfWarlord(final ElfWarlord elfWarlord) {
        this.helpType = elfWarlord.helpType;
    }

    @Override
    public ElfWarlord copy() {
        return new ElfWarlord(this);
    }

    @Override
    public String toString() {
        return "Elven warlord helps in " + this.helpType;
    }
}
