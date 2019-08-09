package com.sensiblemetrics.api.alpenidos.core.visitor4;

public class VisitorPatternLoader {

    public interface Vehicle {
        <R> R accept(final Visitor<? extends R> visitor);
    }

    public static class Car implements Vehicle {
        @Override
        public <R> R accept(final Visitor<? extends R> visitor) {
            return visitor.visitCar(this);
        }
    }

    public static class Moto implements Vehicle {
        @Override
        public <R> R accept(final Visitor<? extends R> visitor) {
            return visitor.visitMoto(this);
        }
    }

    public static class Visitor<R> {
        public R visitMoto(final Moto moto) {
            throw new NoSuchMethodError();
        }

        public R visitCar(final Car car) {
            throw new NoSuchMethodError();
        }
    }

    public static void main(final String[] args) {
        final Visitor<String> visitor = new Visitor<>() {
            @Override
            public String visitCar(final Car car) {
                return "car";
            }

            @Override
            public String visitMoto(final Moto moto) {
                return "moto";
            }
        };

        final Vehicle vehicle = new Car();
        final String text = vehicle.accept(visitor);
        System.out.println(text);
    }
}
