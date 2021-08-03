package com.sensiblemetrics.api.alpenidos.pattern.property.iface;

import com.sensiblemetrics.api.alpenidos.pattern.property.enums.Stats;

/**
 * Interface for prototype inheritance
 */
public interface Prototype {

    Integer get(final Stats stat);

    boolean has(final Stats stat);

    void set(final Stats stat, final Integer val);

    void remove(final Stats stat);
}
