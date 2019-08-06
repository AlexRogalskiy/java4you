package com.sensiblemetrics.api.alpenidos.core.value_object.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * HeroStat is a value object
 *
 * @see <a href="http://docs.oracle.com/javase/8/docs/api/java/lang/doc-files/ValueBased.html">
 * http://docs.oracle.com/javase/8/docs/api/java/lang/doc-files/ValueBased.html
 * </a>
 */
@Data
@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
public class HeroStat {
    // Stats for a hero
    private final int strength;
    private final int intelligence;
    private final int luck;

    // Static factory method to create new instances.
    public static HeroStat valueOf(final int strength, final int intelligence, final int luck) {
        return new HeroStat(strength, intelligence, luck);
    }

    /*
     * Recommended to provide a static factory method capable of creating an instance from the formal
     * string representation declared like this. public static HeroStat parse(String string) {}
     */
    // toString, hashCode, equals
}
