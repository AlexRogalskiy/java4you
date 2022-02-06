package com.sensiblemetrics.api.alpenidos.pattern.vehicle.model;

import java.util.function.Consumer;

public interface Vehicle {

    default void start(final Consumer<Void> preStartChecks) {
        preStartChecks.accept(null);
        System.out.printf("%s starting...%n", this.getClass().getSimpleName());
    }
}
