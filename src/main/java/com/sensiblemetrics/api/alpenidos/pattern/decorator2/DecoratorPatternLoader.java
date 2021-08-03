package com.sensiblemetrics.api.alpenidos.pattern.decorator2;

import com.sensiblemetrics.api.alpenidos.pattern.decorator2.iface.Troll;
import com.sensiblemetrics.api.alpenidos.pattern.decorator2.impl.ClubbedTroll;
import com.sensiblemetrics.api.alpenidos.pattern.decorator2.impl.SimpleTroll;
import lombok.extern.slf4j.Slf4j;

/**
 * The Decorator pattern is a more flexible alternative to subclassing. The Decorator class
 * implements the same interface as the target and uses aggregation to "decorate" calls to the
 * target. Using the Decorator pattern it is possible to change the behavior of the class during
 * runtime.
 * <p>
 * In this example we show how the simple {@link SimpleTroll} first attacks and then flees the battle.
 * Then we decorate the {@link SimpleTroll} with a {@link ClubbedTroll} and perform the attack again. You
 * can see how the behavior changes after the decoration.
 */
@Slf4j
public class DecoratorPatternLoader {

    /**
     * Program entry point
     *
     * @param args command line args
     */
    public static void main(final String[] args) {
        // simple troll
        log.info("A simple looking troll approaches.");
        final Troll troll = new SimpleTroll();
        troll.attack();
        troll.fleeBattle();
        log.info("Simple troll power {}.\n", troll.getAttackPower());

        // change the behavior of the simple troll by adding a decorator
        log.info("A troll with huge club surprises you.");
        final Troll clubbedTroll = new ClubbedTroll(troll);
        clubbedTroll.attack();
        clubbedTroll.fleeBattle();
        log.info("Clubbed troll power {}.\n", clubbedTroll.getAttackPower());
    }
}
