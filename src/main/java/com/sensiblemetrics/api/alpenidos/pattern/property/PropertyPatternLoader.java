package com.sensiblemetrics.api.alpenidos.pattern.property;

import com.sensiblemetrics.api.alpenidos.pattern.property.enums.Stats;
import com.sensiblemetrics.api.alpenidos.pattern.property.iface.Prototype;
import com.sensiblemetrics.api.alpenidos.pattern.property.impl.Character;
import lombok.extern.slf4j.Slf4j;

/**
 * The Property pattern is also known as Prototype inheritance.
 * <p>
 * In prototype inheritance instead of classes, as opposite to Java class inheritance, objects are
 * used to create another objects and object hierarchies. Hierarchies are created using prototype
 * chain through delegation: every object has link to parent object. Any base (parent) object can be
 * amended at runtime (by adding or removal of some property), and all child objects will be
 * affected as result.
 * <p>
 * In this example we demonstrate {@link Character} instantiation using the Property pattern.
 */
@Slf4j
public class PropertyPatternLoader {

    /**
     * Program entry point
     *
     * @param args command line args
     */
    public static void main(final String[] args) {
        /* set up */
        final Prototype charProto = new Character();
        charProto.set(Stats.STRENGTH, 10);
        charProto.set(Stats.AGILITY, 10);
        charProto.set(Stats.ARMOR, 10);
        charProto.set(Stats.ATTACK_POWER, 10);

        final Character mageProto = new Character(Character.Type.MAGE, charProto);
        mageProto.set(Stats.INTELLECT, 15);
        mageProto.set(Stats.SPIRIT, 10);

        final Character warProto = new Character(Character.Type.WARRIOR, charProto);
        warProto.set(Stats.RAGE, 15);
        warProto.set(Stats.ARMOR, 15); // boost default armor for warrior

        final Character rogueProto = new Character(Character.Type.ROGUE, charProto);
        rogueProto.set(Stats.ENERGY, 15);
        rogueProto.set(Stats.AGILITY, 15); // boost default agility for rogue

        /* usage */
        final Character mag = new Character("Player_1", mageProto);
        mag.set(Stats.ARMOR, 8);
        log.info(mag.toString());

        final Character warrior = new Character("Player_2", warProto);
        log.info(warrior.toString());

        final Character rogue = new Character("Player_3", rogueProto);
        log.info(rogue.toString());

        final Character rogueDouble = new Character("Player_4", rogue);
        rogueDouble.set(Stats.ATTACK_POWER, 12);
        log.info(rogueDouble.toString());
    }
}
