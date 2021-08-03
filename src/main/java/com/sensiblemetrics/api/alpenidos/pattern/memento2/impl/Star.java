package com.sensiblemetrics.api.alpenidos.pattern.memento2.impl;

import com.sensiblemetrics.api.alpenidos.pattern.memento2.enums.StarType;
import com.sensiblemetrics.api.alpenidos.pattern.memento2.iface.StarMemento;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Star uses "mementos" to store and restore state.
 */
@AllArgsConstructor
public class Star {
    private StarType type;
    private int ageYears;
    private int massTons;

    /**
     * Makes time pass for the star
     */
    public void timePasses() {
        this.ageYears *= 2;
        this.massTons *= 8;
        switch (this.type) {
            case RED_GIANT:
                this.type = StarType.WHITE_DWARF;
                break;
            case SUN:
                this.type = StarType.RED_GIANT;
                break;
            case SUPERNOVA:
                this.type = StarType.DEAD;
                break;
            case WHITE_DWARF:
                this.type = StarType.SUPERNOVA;
                break;
            case DEAD:
                ageYears *= 2;
                massTons = 0;
                break;
            default:
                break;
        }
    }

    public StarMemento getMemento() {
        final StarMementoInternal state = new StarMementoInternal();
        state.setAgeYears(this.ageYears);
        state.setMassTons(this.massTons);
        state.setType(this.type);
        return state;
    }

    public void setMemento(final StarMemento memento) {
        final StarMementoInternal state = (StarMementoInternal) memento;
        this.type = state.getType();
        this.ageYears = state.getAgeYears();
        this.massTons = state.getMassTons();
    }

    @Override
    public String toString() {
        return String.format("%s age: %d years mass: %d tons", type.toString(), ageYears, massTons);
    }

    /**
     * StarMemento implementation
     */
    @Data
    private static class StarMementoInternal implements StarMemento {
        private StarType type;
        private int ageYears;
        private int massTons;
    }
}
