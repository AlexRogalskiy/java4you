package com.sensiblemetrics.api.alpenidos.pattern.template_method2;

import com.sensiblemetrics.api.alpenidos.pattern.template_method2.factory.HalflingThief;
import com.sensiblemetrics.api.alpenidos.pattern.template_method2.impl.HitAndRunMethod;
import com.sensiblemetrics.api.alpenidos.pattern.template_method2.impl.StealingMethod;
import com.sensiblemetrics.api.alpenidos.pattern.template_method2.impl.SubtleMethod;

/**
 * Template Method defines a skeleton for an algorithm. The algorithm subclasses provide
 * implementation for the blank parts.
 * <p>
 * In this example {@link HalflingThief} contains {@link StealingMethod} that can be changed. First
 * the thief hits with {@link HitAndRunMethod} and then with {@link SubtleMethod}.
 */
public class TemplateMethodPatternLoader {

    /**
     * Program entry point
     *
     * @param args command line args
     */
    public static void main(final String[] args) {
        final HalflingThief thief = new HalflingThief(new HitAndRunMethod());
        thief.steal();

        thief.changeMethod(new SubtleMethod());
        thief.steal();
    }
}
