package com.sensiblemetrics.api.alpenidos.pattern.factory2;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

@Slf4j
public class FactoryPatternLoader {
    enum Color {RED, GREEN, BLUE}

    interface Vehicle {
    }

    @RequiredArgsConstructor
    static class Car implements Vehicle {
        private final Color color;

        @Override
        public String toString() {
            return "Car " + this.color;
        }
    }

    @RequiredArgsConstructor
    static class Moto implements Vehicle {
        private final Color color;

        @Override
        public String toString() {
            return "Moto " + this.color;
        }
    }

    interface VehicleFactory {
        Vehicle create();
    }

    static List<Vehicle> create5(final VehicleFactory factory) {
        return range(0, 5).mapToObj(i -> factory.create()).collect(toList());
    }

    static void main(String[] args) {
        final VehicleFactory redCarFactory = () -> new Car(Color.RED);
        final VehicleFactory blueMotoFactory = () -> new Moto(Color.BLUE);

        log.info("Creating by red car factory: " + create5(redCarFactory));
        log.info("Creating by blue moto factory: " + create5(blueMotoFactory));
    }
}
