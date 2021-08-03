package com.sensiblemetrics.api.alpenidos.pattern.builder2.impl;

import com.sensiblemetrics.api.alpenidos.pattern.builder2.enums.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Hero, the class with many parameters.
 */
@Data
@EqualsAndHashCode
@ToString
public final class Hero {
    private final Profession profession;
    private final String name;
    private final HairType hairType;
    private final HairColorType hairColor;
    private final ArmorType armor;
    private final Weapon weapon;

    private Hero(final Builder builder) {
        this.profession = builder.profession;
        this.name = builder.name;
        this.hairColor = builder.hairColor;
        this.hairType = builder.hairType;
        this.weapon = builder.weapon;
        this.armor = builder.armor;
    }

    /**
     * The builder class.
     */
    public static class Builder {
        private final Profession profession;
        private final String name;

        private HairType hairType;
        private HairColorType hairColor;
        private ArmorType armor;
        private Weapon weapon;

        /**
         * Constructor
         */
        public Builder(final Profession profession, final String name) {
            if (profession == null || name == null) {
                throw new IllegalArgumentException("profession and name can not be null");
            }
            this.profession = profession;
            this.name = name;
        }

        public Builder withHairType(final HairType hairType) {
            this.hairType = hairType;
            return this;
        }

        public Builder withHairColor(final HairColorType hairColor) {
            this.hairColor = hairColor;
            return this;
        }

        public Builder withArmor(final ArmorType armor) {
            this.armor = armor;
            return this;
        }

        public Builder withWeapon(final Weapon weapon) {
            this.weapon = weapon;
            return this;
        }

        public Hero build() {
            return new Hero(this);
        }
    }
}
