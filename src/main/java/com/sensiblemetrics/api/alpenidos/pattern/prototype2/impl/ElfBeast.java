package com.sensiblemetrics.api.alpenidos.pattern.prototype2.impl;

/**
 * ElfBeast
 */
public class ElfBeast extends Beast {
    private String helpType;

    public ElfBeast(final String helpType) {
        this.helpType = helpType;
    }

    public ElfBeast(final ElfBeast elfBeast) {
        this.helpType = elfBeast.helpType;
    }

    @Override
    public Beast copy() {
        return new ElfBeast(this);
    }

    @Override
    public String toString() {
        return "Elven eagle helps in " + this.helpType;
    }
}
