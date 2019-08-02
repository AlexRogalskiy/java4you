package com.sensiblemetrics.api.alpenidos.core.mediator;

import com.sensiblemetrics.api.alpenidos.core.mediator.iface.Aircraft;
import com.sensiblemetrics.api.alpenidos.core.mediator.impl.AirportControl;
import com.sensiblemetrics.api.alpenidos.core.mediator.impl.Plane;

public class MediatorPatternLoader {
    public static void main(String[] args) {
        final AirportControl airportControl = new AirportControl();

        final Aircraft aircraftA = new Plane("A", 0);
        final Aircraft aircraftB = new Plane("B", 10);

        aircraftA.setControl(airportControl);
        aircraftB.setControl(airportControl);

        System.out.println(aircraftA);
        System.out.println(aircraftB);
        System.out.println();

        final Aircraft aircraftC = new Plane("C", 20);
        aircraftC.setControl(airportControl);

        System.out.println(aircraftA);
        System.out.println(aircraftB);
        System.out.println(aircraftC);
        System.out.println();

        aircraftA.moveTo(10);
        aircraftA.moveTo(30);

        System.out.println(aircraftA);
        System.out.println(aircraftB);
        System.out.println(aircraftC);
        System.out.println();
    }
}
