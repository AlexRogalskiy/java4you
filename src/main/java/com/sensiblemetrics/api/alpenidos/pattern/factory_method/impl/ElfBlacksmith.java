package com.sensiblemetrics.api.alpenidos.pattern.factory_method.impl;

import com.sensiblemetrics.api.alpenidos.pattern.factory_method.enums.WeaponType;
import com.sensiblemetrics.api.alpenidos.pattern.factory_method.iface.Blacksmith;
import com.sensiblemetrics.api.alpenidos.pattern.factory_method.iface.Weapon;

/**
 * Concrete subclass for creating new objects.
 */
public class ElfBlacksmith implements Blacksmith {

    @Override
    public Weapon manufactureWeapon(final WeaponType weaponType) {
        return new ElfWeapon(weaponType);
    }
}
