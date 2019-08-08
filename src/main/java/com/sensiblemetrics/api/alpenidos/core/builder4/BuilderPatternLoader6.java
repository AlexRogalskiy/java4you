package com.sensiblemetrics.api.alpenidos.core.builder4;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class BuilderPatternLoader6 {

    public interface Vehicle {
    }

    public static class Car implements Vehicle {
        @Override
        public String toString() {
            return "Car ";
        }
    }

    public static class Moto implements Vehicle {
        @Override
        public String toString() {
            return "Moto ";
        }
    }

    public static class Builder {
        private final Map<String, Supplier<? extends Vehicle>> map = new HashMap<>();

        public void register(final String name, final Supplier<? extends Vehicle> supplier) {
            this.map.put(name, supplier);
        }

        public VehicleFactory toFactory() {
            return name -> this.map.getOrDefault(name, unknown(name)).get();
        }

        private Supplier<Vehicle> unknown(final String name) {
            return () -> {
                throw new IllegalArgumentException("Unknown " + name);
            };
        }
    }

    public interface VehicleFactory {
        Vehicle create(final String name);
    }

    public static void main(final String[] args) {
        final Builder builder = new Builder();
        builder.register("car", Car::new);
        builder.register("moto", Moto::new);
        final VehicleFactory factory = builder.toFactory();

        final Vehicle vehicle1 = factory.create("car");
        System.out.println(vehicle1);
        final Vehicle vehicle2 = factory.create("moto");
        System.out.println(vehicle2);
    }
}
