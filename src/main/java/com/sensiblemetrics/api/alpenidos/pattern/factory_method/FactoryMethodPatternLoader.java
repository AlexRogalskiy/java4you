package com.sensiblemetrics.api.alpenidos.pattern.factory_method;

import com.sensiblemetrics.api.alpenidos.pattern.factory_method.enums.WeaponType;
import com.sensiblemetrics.api.alpenidos.pattern.factory_method.iface.Blacksmith;
import com.sensiblemetrics.api.alpenidos.pattern.factory_method.iface.Weapon;
import com.sensiblemetrics.api.alpenidos.pattern.factory_method.impl.ElfBlacksmith;
import com.sensiblemetrics.api.alpenidos.pattern.factory_method.impl.OrcBlacksmith;
import lombok.extern.slf4j.Slf4j;

/**
 * The Factory Method is a creational design pattern which uses factory methods to deal with the
 * problem of creating objects without specifying the exact class of object that will be created.
 * This is done by creating objects via calling a factory method either specified in an interface
 * and implemented by child classes, or implemented in a base class and optionally overridden by
 * derived classes—rather than by calling a constructor.
 * <p>
 * In this Factory Method example we have an interface ({@link Blacksmith}) with a method for
 * creating objects ({@link Blacksmith#manufactureWeapon}). The concrete subclasses (
 * {@link OrcBlacksmith}, {@link ElfBlacksmith}) then override the method to produce objects of
 * their liking.
 */
@Slf4j
public class FactoryMethodPatternLoader {

    private final Blacksmith blacksmith;

    /**
     * Creates an instance of <code>FactoryMethodPatternLoader</code> which will use <code>blacksmith</code> to manufacture
     * the weapons for war.
     * <code>FactoryMethodPatternLoader</code> is unaware which concrete implementation of {@link Blacksmith} it is using.
     * The decision of which blacksmith implementation to use may depend on configuration, or
     * the type of rival in war.
     *
     * @param blacksmith a non-null implementation of blacksmith
     */
    public FactoryMethodPatternLoader(final Blacksmith blacksmith) {
        this.blacksmith = blacksmith;
    }

    /**
     * Program entry point
     *
     * @param args command line args
     */
    public static void main(String[] args) {
        // Lets go to war with Orc weapons
        FactoryMethodPatternLoader app = new FactoryMethodPatternLoader(new OrcBlacksmith());
        app.manufactureWeapons();

        // Lets go to war with Elf weapons
        app = new FactoryMethodPatternLoader(new ElfBlacksmith());
        app.manufactureWeapons();
    }

    private void manufactureWeapons() {
        Weapon weapon = this.blacksmith.manufactureWeapon(WeaponType.SPEAR);
        log.info(weapon.toString());
        weapon = blacksmith.manufactureWeapon(WeaponType.AXE);
        log.info(weapon.toString());
    }
}
