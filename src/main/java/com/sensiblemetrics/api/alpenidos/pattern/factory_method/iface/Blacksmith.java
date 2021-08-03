package com.sensiblemetrics.api.alpenidos.pattern.factory_method.iface;

import com.sensiblemetrics.api.alpenidos.pattern.factory_method.enums.WeaponType;

/**
 * The interface containing method for producing objects.
 */
public interface Blacksmith {

    Weapon manufactureWeapon(final WeaponType weaponType);
}
