package com.sensiblemetrics.api.alpenidos.pattern.mediator;

import com.sensiblemetrics.api.alpenidos.pattern.mediator.iface.Aircraft;
import com.sensiblemetrics.api.alpenidos.pattern.mediator.impl.AirportControl;
import com.sensiblemetrics.api.alpenidos.pattern.mediator.impl.Plane;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MediatorPatternLoader {

    public static void main(final String[] args) {
        final AirportControl airportControl = new AirportControl();

        final Aircraft aircraftA = new Plane("A", 0);
        final Aircraft aircraftB = new Plane("B", 10);

        aircraftA.setControl(airportControl);
        aircraftB.setControl(airportControl);

        log.debug(String.valueOf(aircraftA));
        log.debug(String.valueOf(aircraftB));

        final Aircraft aircraftC = new Plane("C", 20);
        aircraftC.setControl(airportControl);

        log.debug(String.valueOf(aircraftA));
        log.debug(String.valueOf(aircraftB));
        log.debug(String.valueOf(aircraftC));

        aircraftA.moveTo(10);
        aircraftA.moveTo(30);

        log.debug(String.valueOf(aircraftA));
        log.debug(String.valueOf(aircraftB));
        log.debug(String.valueOf(aircraftC));
    }
}
