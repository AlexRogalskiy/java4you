package com.sensiblemetrics.api.alpenidos.pattern.specification.selector;

import com.sensiblemetrics.api.alpenidos.pattern.specification.model.iface.Creature;
import com.sensiblemetrics.api.alpenidos.pattern.specification.property.Movement;
import java.util.function.Predicate;
import lombok.RequiredArgsConstructor;

/**
 * Movement selector.
 */
@RequiredArgsConstructor
public class MovementSelector implements Predicate<Creature> {

    private final Movement m;

    @Override
    public boolean test(final Creature t) {
        return t.getMovement().equals(this.m);
    }
}
