package com.sensiblemetrics.api.alpenidos.core.specification.selector;

import com.sensiblemetrics.api.alpenidos.core.specification.model.iface.Creature;
import com.sensiblemetrics.api.alpenidos.core.specification.property.Color;
import lombok.RequiredArgsConstructor;

import java.util.function.Predicate;

/**
 * Color selector.
 */
@RequiredArgsConstructor
public class ColorSelector implements Predicate<Creature> {
    private final Color c;

    @Override
    public boolean test(final Creature t) {
        return t.getColor().equals(this.c);
    }
}
