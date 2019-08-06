package com.sensiblemetrics.api.alpenidos.core.step_builder.impl;

import com.sensiblemetrics.api.alpenidos.core.step_builder.model.Character;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The Step Builder class.
 */
@NoArgsConstructor
public final class CharacterStepBuilder {

    public static NameStep newBuilder() {
        return new CharacterSteps();
    }

    /**
     * First Builder Step in charge of the Character name. Next Step available : ClassStep
     */
    public interface NameStep {
        ClassStep name(final String name);
    }

    /**
     * This step is in charge of setting the Character class (fighter or wizard). Fighter choice :
     * Next Step available : WeaponStep Wizard choice : Next Step available : SpellStep
     */
    public interface ClassStep {
        WeaponStep fighterClass(final String fighterClass);

        SpellStep wizardClass(final String wizardClass);
    }

    /**
     * This step is in charge of the weapon. Weapon choice : Next Step available : AbilityStep No
     * weapon choice : Next Step available : BuildStep
     */
    public interface WeaponStep {
        AbilityStep withWeapon(final String weapon);

        BuildStep noWeapon();
    }

    /**
     * This step is in charge of the spell. Spell choice : Next Step available : AbilityStep No spell
     * choice : Next Step available : BuildStep
     */
    public interface SpellStep {
        AbilityStep withSpell(final String spell);

        BuildStep noSpell();
    }

    /**
     * This step is in charge of abilities. Next Step available : BuildStep
     */
    public interface AbilityStep {
        AbilityStep withAbility(final String ability);

        BuildStep noMoreAbilities();

        BuildStep noAbilities();
    }

    /**
     * This is the final step in charge of building the Character Object. Validation should be here.
     */
    public interface BuildStep {
        Character build();
    }

    /**
     * Step Builder implementation.
     */
    private static class CharacterSteps implements NameStep, ClassStep, WeaponStep, SpellStep, AbilityStep, BuildStep {
        private String name;
        private String fighterClass;
        private String wizardClass;
        private String weapon;
        private String spell;
        private final List<String> abilities = new ArrayList<>();

        @Override
        public ClassStep name(final String name) {
            this.name = name;
            return this;
        }

        @Override
        public WeaponStep fighterClass(final String fighterClass) {
            this.fighterClass = fighterClass;
            return this;
        }

        @Override
        public SpellStep wizardClass(final String wizardClass) {
            this.wizardClass = wizardClass;
            return this;
        }

        @Override
        public AbilityStep withWeapon(final String weapon) {
            this.weapon = weapon;
            return this;
        }

        @Override
        public BuildStep noWeapon() {
            return this;
        }

        @Override
        public AbilityStep withSpell(final String spell) {
            this.spell = spell;
            return this;
        }

        @Override
        public BuildStep noSpell() {
            return this;
        }

        @Override
        public AbilityStep withAbility(final String ability) {
            this.abilities.add(ability);
            return this;
        }

        @Override
        public BuildStep noMoreAbilities() {
            return this;
        }

        @Override
        public BuildStep noAbilities() {
            return this;
        }

        @Override
        public Character build() {
            final Character character = new Character(this.name);
            Optional.ofNullable(this.fighterClass).ifPresentOrElse(v -> character.setFighterClass(v), () -> character.setWizardClass(wizardClass));
            Optional.ofNullable(this.weapon).ifPresentOrElse(v -> character.setWeapon(v), () -> character.setSpell(spell));
            if (!this.abilities.isEmpty()) {
                character.setAbilities(this.abilities);
            }
            return character;
        }
    }
}
