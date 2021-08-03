package com.sensiblemetrics.api.alpenidos.pattern.specification.selector;

import com.sensiblemetrics.api.alpenidos.pattern.specification.model.iface.Creature;
import com.sensiblemetrics.api.alpenidos.pattern.specification.property.Size;
import java.util.function.Predicate;
import lombok.RequiredArgsConstructor;

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
