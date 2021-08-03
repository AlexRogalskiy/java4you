package com.sensiblemetrics.api.alpenidos.pattern.value_object;

import com.sensiblemetrics.api.alpenidos.pattern.value_object.model.HeroStat;
import lombok.extern.slf4j.Slf4j;

/**
 * A Value Object are objects which follow value semantics rather than reference semantics. This
 * means value objects' equality are not based on identity. Two value objects are equal when they
 * have the same value, not necessarily being the same object..
 * <p>
 * Value Objects must override equals(), hashCode() to check the equality with values.
 * Value Objects should be immutable so declare members final.
 * Obtain instances by static factory methods.
 * The elements of the state must be other values, including primitive types.
 * Provide methods, typically simple getters, to get the elements of the state.
 * A Value Object must check equality with equals() not ==
 * <p>
 * For more specific and strict rules to implement value objects check the rules from Stephen
 * Colebourne's term VALJO : http://blog.joda.org/2014/03/valjos-value-java-objects.html
 */
@Slf4j
public class ValueObjectPatternLoader {

    /**
     * This practice creates three HeroStats(Value object) and checks equality between those.
     */
    public static void main(final String[] args) {
        final HeroStat statA = HeroStat.valueOf(10, 5, 0);
        final HeroStat statB = HeroStat.valueOf(10, 5, 0);
        final HeroStat statC = HeroStat.valueOf(5, 1, 8);

        log.info(statA.toString());

        log.info("Is statA and statB equal : {}", statA.equals(statB));
        log.info("Is statA and statC equal : {}", statA.equals(statC));
    }
}
