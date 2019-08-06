package com.sensiblemetrics.api.alpenidos.core.step_builder;

import com.sensiblemetrics.api.alpenidos.core.step_builder.impl.CharacterStepBuilder;
import com.sensiblemetrics.api.alpenidos.core.step_builder.model.Character;
import lombok.extern.slf4j.Slf4j;

/**
 * Step Builder Pattern
 *
 * <p>
 * <b>Intent</b> <br>
 * An extension of the Builder pattern that fully guides the user through the creation of the object
 * with no chances of confusion. <br>
 * The user experience will be much more improved by the fact that he will only see the next step
 * methods available, NO build method until is the right time to build the object.
 *
 * <p>
 * <b>Implementation</b> <br>
 * The concept is simple:
 * <ul>
 *
 * <li>Write creational steps inner classes or interfaces where each method knows what can be
 * displayed next.</li>
 *
 * <li>Implement all your steps interfaces in an inner static class.</li>
 *
 * <li>Last step is the BuildStep, in charge of creating the object you need to build.</li>
 * </ul>
 *
 * <p>
 * <b>Applicability</b> <br>
 * Use the Step Builder pattern when the algorithm for creating a complex object should be
 * independent of the parts that make up the object and how they're assembled the construction
 * process must allow different representations for the object that's constructed when in the
 * process of constructing the order is important.
 * <p>
 *
 * @see <a href="http://rdafbn.blogspot.co.uk/2012/07/step-builder-pattern_28.html">http://rdafbn.blogspot.co.uk/2012/07/step-builder-pattern_28.html</a>
 */
@Slf4j
public class StepBuilderPatternLoader {

    /**
     * Program entry point
     *
     * @param args command line args
     */
    public static void main(final String[] args) {
        final Character warrior = CharacterStepBuilder
            .newBuilder()
            .name("Amberjill")
            .fighterClass("Paladin")
            .withWeapon("Sword")
            .noAbilities()
            .build();
        log.info(warrior.toString());

        final Character mage = CharacterStepBuilder
            .newBuilder()
            .name("Riobard")
            .wizardClass("Sorcerer")
            .withSpell("Fireball")
            .withAbility("Fire Aura")
            .withAbility("Teleport")
            .noMoreAbilities()
            .build();
        log.info(mage.toString());

        final Character thief = CharacterStepBuilder
            .newBuilder()
            .name("Desmond")
            .fighterClass("Rogue")
            .noWeapon()
            .build();
        log.info(thief.toString());
    }
}
