package com.sensiblemetrics.api.alpenidos.pattern.factory_kit.iface;

import com.sensiblemetrics.api.alpenidos.pattern.factory_kit.enums.WeaponType;

import java.util.function.Supplier;

/**
 * Functional interface that allows adding builder with name to the factory.
 */
public interface Builder {

    void add(final WeaponType name, final Supplier<Weapon> supplier);
}
