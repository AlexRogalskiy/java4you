package com.sensiblemetrics.api.alpenidos.core.specification.selector;

import com.sensiblemetrics.api.alpenidos.core.specification.model.iface.Creature;
import com.sensiblemetrics.api.alpenidos.core.specification.property.Size;
import lombok.RequiredArgsConstructor;

import java.util.function.Predicate;

/**
 * Size selector.
 */
@RequiredArgsConstructor
public class SizeSelector implements Predicate<Creature> {
    private final Size s;

    @Override
    public boolean test(final Creature t) {
        return t.getSize().equals(this.s);
    }
}
