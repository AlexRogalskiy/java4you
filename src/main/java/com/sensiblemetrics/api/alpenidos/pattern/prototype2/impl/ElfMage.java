package com.sensiblemetrics.api.alpenidos.pattern.prototype2.impl;

/**
 * ElfMage
 */
public class ElfMage extends Mage {
    private String helpType;

    public ElfMage(final String helpType) {
        this.helpType = helpType;
    }

    public ElfMage(final ElfMage elfMage) {
        this.helpType = elfMage.helpType;
    }

    @Override
    public ElfMage copy() {
        return new ElfMage(this);
    }

    @Override
    public String toString() {
        return "Elven mage helps in " + this.helpType;
    }
}
