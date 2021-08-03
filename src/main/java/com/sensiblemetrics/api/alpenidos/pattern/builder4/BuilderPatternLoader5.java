package com.sensiblemetrics.api.alpenidos.pattern.builder4;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class BuilderPatternLoader5 {

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

    public interface Builder {
        void register(final String name, final Supplier<? extends Vehicle> supplier);
    }

    public interface VehicleFactory {
        Vehicle create(final String name);

        static VehicleFactory create(final Consumer<Builder> consumer) {
            final Map<String, Supplier<? extends Vehicle>> map = new HashMap<>();
            consumer.accept(map::put);
            return name -> map.getOrDefault(name, unknown(name)).get();
        }

        static Supplier<Vehicle> unknown(final String name) {
            return () -> {
                throw new IllegalArgumentException("Unknown " + name);
            };
        }
    }

    public static void main(final String[] args) {
        final VehicleFactory factory = VehicleFactory.create(builder -> {
            builder.register("car", Car::new);
            builder.register("moto", Moto::new);
        });

        final Vehicle vehicle1 = factory.create("car");
        System.out.println(vehicle1);
        final Vehicle vehicle2 = factory.create("moto");
        System.out.println(vehicle2);
    }
}
