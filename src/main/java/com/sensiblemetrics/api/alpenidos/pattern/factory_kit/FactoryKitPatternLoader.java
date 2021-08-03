package com.sensiblemetrics.api.alpenidos.pattern.factory_kit;

import com.sensiblemetrics.api.alpenidos.pattern.factory_kit.enums.WeaponType;
import com.sensiblemetrics.api.alpenidos.pattern.factory_kit.iface.Builder;
import com.sensiblemetrics.api.alpenidos.pattern.factory_kit.iface.Weapon;
import com.sensiblemetrics.api.alpenidos.pattern.factory_kit.iface.WeaponFactory;
import com.sensiblemetrics.api.alpenidos.pattern.factory_kit.model.Axe;
import com.sensiblemetrics.api.alpenidos.pattern.factory_kit.model.Bow;
import com.sensiblemetrics.api.alpenidos.pattern.factory_kit.model.Spear;
import com.sensiblemetrics.api.alpenidos.pattern.factory_kit.model.Sword;
import lombok.extern.slf4j.Slf4j;

/**
 * Factory-kit is a creational pattern which defines a factory of immutable content
 * with separated builder and factory interfaces to deal with the problem of
 * creating one of the objects specified directly in the factory-kit instance.
 *
 * <p>
 * In the given example {@link WeaponFactory} represents the factory-kit, that contains
 * four {@link Builder}s for creating new objects of
 * the classes implementing {@link Weapon} interface.
 * <br>Each of them can be called with {@link WeaponFactory#create(WeaponType)} method, with
 * an input representing an instance of {@link WeaponType} that needs to
 * be mapped explicitly with desired class type in the factory instance.
 */
@Slf4j
public class FactoryKitPatternLoader {

    /**
     * Program entry point.
     *
     * @param args command line args
     */
    public static void main(final String[] args) {
        final WeaponFactory factory = WeaponFactory.factory(builder -> {
            builder.add(WeaponType.SWORD, Sword::new);
            builder.add(WeaponType.AXE, Axe::new);
            builder.add(WeaponType.SPEAR, Spear::new);
            builder.add(WeaponType.BOW, Bow::new);
        });
        final Weapon axe = factory.create(WeaponType.AXE);
        log.info(axe.toString());
    }
}
