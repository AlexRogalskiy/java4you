package com.sensiblemetrics.api.alpenidos.core.mediator.impl;

import com.sensiblemetrics.api.alpenidos.core.mediator.iface.Aircraft;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tully.
 * <p>
 * Mediator in the Mediator pattern.
 */
public class AirportControl {
    private final Map<Aircraft, Integer> positions = new HashMap<>();

    /**
     * Message to all aircrafts
     *
     * @param aircraft which moved to a new sector
     */
    public void moved(final Aircraft aircraft) {
        int previousSector = this.positions.get(aircraft);
        this.positions.forEach((key, value) -> {
            if (!key.equals(aircraft)) {
                key.removeDangerousSector(previousSector);
                key.addDangerousSector(aircraft.getSector());
            }
        });
        this.positions.put(aircraft, aircraft.getSector());
    }

    /**
     * store() method in Mediator pattern
     *
     * @param aircraft aircraft to store
     */

    public void addAircraft(final Aircraft aircraft) {
        this.positions.forEach((key, value) -> {
            key.addDangerousSector(aircraft.getSector());
            aircraft.addDangerousSector(value);
        });
        this.positions.put(aircraft, aircraft.getSector());
    }
}
