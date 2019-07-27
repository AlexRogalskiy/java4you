package com.sensiblemetrics.api.alpenidos.core.mediator.impl;

import com.sensiblemetrics.api.alpenidos.core.mediator.iface.Aircraft;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by tully.
 */
@EqualsAndHashCode
@ToString
public class Plane implements Aircraft {
    private final Set<Integer> dangerous = new HashSet<>();

    private AirportControl control;
    private String name;
    private int selfSector;

    public Plane(final String name, final int selfSector) {
        this.name = name;
        this.selfSector = selfSector;
    }

    @Override
    public void setControl(final AirportControl control) {
        this.control = control;
        this.control.addAircraft(this);
    }

    @Override
    public void moveTo(int sector) {
        if (this.dangerous.contains(sector)) {
            System.out.println("Can't move to: " + sector);
        } else {
            this.selfSector = sector;
        }
        this.control.moved(this);
    }

    @Override
    public void addDangerousSector(int sector) {
        this.dangerous.add(sector);
    }

    @Override
    public void removeDangerousSector(int sector) {
        this.dangerous.remove(sector);
    }

    @Override
    public int getSector() {
        return this.selfSector;
    }
}
