package com.sensiblemetrics.api.alpenidos.pattern.factory_method.impl;

import com.sensiblemetrics.api.alpenidos.pattern.factory_method.enums.WeaponType;
import com.sensiblemetrics.api.alpenidos.pattern.factory_method.iface.Weapon;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * OrcWeapon.
 */
@Getter
@RequiredArgsConstructor
public class OrcWeapon implements Weapon {
    private final WeaponType weaponType;

    @Override
    public String toString() {
        return "Orcish " + weaponType;
    }
}
