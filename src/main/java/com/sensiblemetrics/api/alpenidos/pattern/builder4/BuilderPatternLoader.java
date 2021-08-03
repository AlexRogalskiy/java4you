package com.sensiblemetrics.api.alpenidos.pattern.builder4;

import java.util.function.Supplier;

public class BuilderPatternLoader {

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
        public void register(final String name, final Supplier<? extends Vehicle> supplier) {
            throw new UnsupportedOperationException("TODO");
        }

        public VehicleFactory toFactory() {
            throw new UnsupportedOperationException("TODO");
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
